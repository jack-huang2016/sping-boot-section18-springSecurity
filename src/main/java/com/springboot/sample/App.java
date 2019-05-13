package com.springboot.sample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springboot.sample.mapper") //扫描该包路径下的所有mapper
public class App  
{
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
    }
}
