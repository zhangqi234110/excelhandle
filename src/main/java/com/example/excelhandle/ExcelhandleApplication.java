package com.example.excelhandle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.excelhandle.mapper")
public class ExcelhandleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExcelhandleApplication.class, args);
    }

}
