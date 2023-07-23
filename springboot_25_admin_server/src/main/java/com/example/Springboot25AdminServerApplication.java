package com.example;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//设置启用Spring-Admin
@EnableAdminServer
public class Springboot25AdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot25AdminServerApplication.class, args);
    }

}
