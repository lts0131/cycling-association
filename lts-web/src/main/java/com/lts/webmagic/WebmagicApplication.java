package com.lts.webmagic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.lts.school.service"})
@MapperScan(basePackages = "com.lts.school.mapper.*",sqlSessionFactoryRef = "miSqlSessionFactory")

public class WebmagicApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebmagicApplication.class, args);
	}
}
