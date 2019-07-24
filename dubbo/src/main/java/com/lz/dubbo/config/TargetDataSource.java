package com.lz.dubbo.config;

import java.lang.annotation.*;

/**
 * 在方法上使用，用于指定使用哪个数据源
 * @author DELL
 * @create 2019/7/1
 * @since 1.0.0
 */

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String name();
}
