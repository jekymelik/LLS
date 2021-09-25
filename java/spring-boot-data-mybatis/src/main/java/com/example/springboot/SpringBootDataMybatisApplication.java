package com.example.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan(value = "com.example.springboot.mapper")
@SpringBootApplication
public class SpringBootDataMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataMybatisApplication.class, args);
    }

}
