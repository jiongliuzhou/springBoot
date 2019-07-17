package com.lz.goods.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态数据源注册
 * 启动动态数据源请在启动类中（如SpringBootSampleApplication）
 * 添加 @Import(DynamicDataSourceRegister.class)
 * @author lz
 * @create 2019/7/1
 * @since 1.0.0
 */
public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {
    private Logger logger = LoggerFactory.getLogger(DynamicDataSourceRegister.class);

    private static final String PARAM="dataSource";

    /**
     * 指定默认数据源
     */
    private static final String DATASOURCE_TYPE_DEFAULT = "org.apache.tomcat.jdbc.pool.DataSource";
    /**
     * 默认数据源
     */
    private DataSource defaultDataSource;
    /**
     * 用户自定义数据源
     */
    private Map<String, DataSource> slaveDataSources = new HashMap<>();

    @Override
    public void setEnvironment(Environment environment) {
        initDefaultDataSource(environment);
        initslaveDataSources(environment);
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        //添加默认数据源
        targetDataSources.put(PARAM, this.defaultDataSource);
        DynamicDataSourceContextHolder.dataSourceIds.add(PARAM);
        //添加其他数据源
        targetDataSources.putAll(slaveDataSources);
        for (String key : slaveDataSources.keySet()) {
            DynamicDataSourceContextHolder.dataSourceIds.add(key);
        }
        //创建DynamicDataSource
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        beanDefinition.setSynthetic(true);
        MutablePropertyValues mpv = beanDefinition.getPropertyValues();
        mpv.addPropertyValue("defaultTargetDataSource", defaultDataSource);
        mpv.addPropertyValue("targetDataSources", targetDataSources);
        //注册BeanDefinitionRegistry
        beanDefinitionRegistry.registerBeanDefinition(PARAM, beanDefinition);
        logger.info("Dynamic DataSource Registry");
    }

    /**
     * 初始化默认数据源
     * @param env
     */
    private void initDefaultDataSource(Environment env) {
        Map<String, Object> dsMap =setDataSourceProperty(env,"spring.datasource");
        defaultDataSource = buildDataSource(dsMap);
    }

    /**
     * 初始化更多数据源
     * @param env
     */
    private void initslaveDataSources(Environment env) {
        // 读取配置文件获取更多数据源
        String dsPreFixs = env.getProperty("custom.datasource.names");
        for (String dsPrefix : dsPreFixs.split(",")) {
            //多个数据源
            Map<String, Object> dsMap =setDataSourceProperty(env,"custom.datasource."+ dsPrefix);
            DataSource ds = buildDataSource(dsMap);
            slaveDataSources.put(dsPrefix, ds);
        }
    }

    /**
     * 构建数据源
     * @param dataSourceMap
     * @return
     */
    public DataSource buildDataSource(Map<String, Object> dataSourceMap) {
        try {
            Object type = dataSourceMap.get("type");
            if (type == null) {
                //默认DataSource
                type = DATASOURCE_TYPE_DEFAULT;
            }
            Class<? extends DataSource> dataSourceType;
            dataSourceType = (Class<? extends DataSource>) Class.forName((String) type);
            String driverClassName = dataSourceMap.get("driver").toString();
            String url = dataSourceMap.get("url").toString();
            String username = dataSourceMap.get("username").toString();
            String password = dataSourceMap.get("password").toString();
            //自定义DataSource配置
            DataSourceBuilder factory = DataSourceBuilder.create()
                    .driverClassName(driverClassName)
                    .url(url)
                    .username(username)
                    .password(password)
                    .type(dataSourceType);
            return factory.build();
        } catch (ClassNotFoundException e) {
            logger.debug(e.getMessage());
        }
        return null;
    }

    private Map<String, Object> setDataSourceProperty(Environment env, String preFix){
        Map<String, Object> dsMap = new HashMap<>();
        dsMap.put("type", env.getProperty(preFix+ ".type"));
        dsMap.put("driver", env.getProperty(preFix+ ".driver-class-name"));
        dsMap.put("url", env.getProperty(preFix+ ".url"));
        dsMap.put("username", env.getProperty(preFix+ ".username"));
        dsMap.put("password", env.getProperty(preFix+ ".password"));
        return dsMap;
    }

}
