package com.lz.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.lz.dubbo.config.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@MapperScan("com.lz.dubbo.mapper")
@EnableDubbo(scanBasePackages ="com.lz.dubbo")
//注册动态多数据源
@Import({DynamicDataSourceRegister.class})
public class DubboApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboApplication.class, args);
	}

}
