package com.itheima.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.config
 * @Author: ASUS
 * @CreateTime: 2023-07-17  08:45
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
public class MsgConfig {

    @Bean
    public String msg(){
        return "bean msg";
    }
}
