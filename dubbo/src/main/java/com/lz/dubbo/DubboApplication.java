package com.lz.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages ="com.zl.dubbo")
public class DubboApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboApplication.class, args);
	}

}
