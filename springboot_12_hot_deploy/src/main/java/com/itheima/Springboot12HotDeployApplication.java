package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot12HotDeployApplication {

    public static void main(String[] args) {
//        System.setProperty("spring.devtools.restart.enabled","false");
        SpringApplication.run(Springboot12HotDeployApplication.class, args);
    }

}
