package com.example;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springboot13ConfigurationApplication {

    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DruidDataSource datasource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication
                .run(
                Springboot13ConfigurationApplication.class, args);
        DruidDataSource bean = run.getBean(DruidDataSource.class);
        System.out.println(bean.getDriverClassName());//com.mysql.jdbc.Driver123
    }

}
