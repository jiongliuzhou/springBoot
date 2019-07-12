package com.lz.goods.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 〈动态数据源配置〉
 * @author DELL
 * @create 2019/7/1
 * @since 1.0.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}
