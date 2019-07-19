package com.lz.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lz.dubbo.mapper")
@EnableDubbo(scanBasePackages ="com.lz.dubbo")
public class DubboApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboApplication.class, args);
	}

}
