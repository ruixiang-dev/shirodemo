package com.crx.shirodemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.crx.shirodemo.mapper")
public class ShirodemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShirodemoApplication.class, args);
    }

}
