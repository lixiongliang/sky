package com.hgshequ.springbootai;

import com.hgshequ.springbootai.config.HelloProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication(scanBasePackages = {"com.hgshequ.springbootai"})
@EnableConfigurationProperties(HelloProperties.class)
@MapperScan(basePackages = {"com.hgshequ.springbootai.mapper"})
public class SpringbootaiApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringbootaiApplication.class, args);


    }

}
