package com.hgshequ.springbootai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


 @SpringBootApplication(scanBasePackages = {"com.hgshequ.springbootai"})
 @MapperScan(basePackages= {"com.hgshequ.springbootai.mapper"})
public class SpringbootaiApplication {



    public static void main(String[] args) {
        SpringApplication.run(SpringbootaiApplication.class, args);



 }

}
