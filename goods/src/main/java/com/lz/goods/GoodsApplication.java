package com.lz.goods;

import com.lz.goods.config.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan("com.lz")
@MapperScan("com.lz.goods.mapper")
@EnableTransactionManagement
//注册动态多数据源
@Import({DynamicDataSourceRegister.class})
public class GoodsApplication {
	public static void main(String[] args) {
		SpringApplication.run(GoodsApplication.class, args);
	}

}
