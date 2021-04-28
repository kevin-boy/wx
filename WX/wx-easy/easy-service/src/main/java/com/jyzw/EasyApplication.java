package com.jyzw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jyzw.mapper")
public class EasyApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyApplication.class,args);
    }
}
