package com.lz.dubbo.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lz
 * @create 2019/7/1
 * @since 1.0.0
 */
public class DynamicDataSourceContextHolder {
    private DynamicDataSourceContextHolder(){

    }
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    protected static final List<String> dataSourceIds = new ArrayList<>();

    public static void setDataSourceType(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }

    public static String getDataSourceType() {
        return contextHolder.get();
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }

    /**
     * 判断指定DataSrouce当前是否存在
     * @param dataSourceId
     */
    public static boolean containsDataSource(String dataSourceId){
        return dataSourceIds.contains(dataSourceId);
    }
}
