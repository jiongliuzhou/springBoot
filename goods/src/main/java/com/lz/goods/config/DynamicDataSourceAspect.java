package com.lz.goods.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 对标记有@TargetDataSource注解的方法进行数据源动态切换，
 * 没有@TargetDataSource使用默认数据源
 * @author lz
 * @create 2019/7/1
 * @since 1.0.0
 */
@Aspect
//保证AOP在@Transactional之前执行
@Order(-1)
@Component
@Slf4j
public class DynamicDataSourceAspect {

    @Before("@annotation(ds)")
    public void changeDataSource(JoinPoint point, TargetDataSource ds){
        String dsId = ds.name();
        if (!DynamicDataSourceContextHolder.containsDataSource(dsId)) {
            log.error("数据源["+ds.name()+"]不存在，使用默认数据源 > "+point.getSignature());
        } else {
            log.debug("Use DataSource : "+ds.name()+" >"+point.getSignature());
            DynamicDataSourceContextHolder.setDataSourceType(ds.name());
        }
    }

    @After("@annotation(ds)")
    public void restoreDataSource(JoinPoint point, TargetDataSource ds) {
        log.debug("Revert DataSource : "+ds.name()+" >"+point.getSignature());
        DynamicDataSourceContextHolder.clearDataSourceType();
    }

}
