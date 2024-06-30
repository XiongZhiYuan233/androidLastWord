package com.example.demo;

import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@MapperScan("com.example.demo")
public class DemoApplication {

    public static void main(String[] args) {
        System.setProperty("server.port","8080");
        SpringApplication.run(DemoApplication.class, args);
    }

}
