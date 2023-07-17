package com.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.example.config
 * @Author: ASUS
 * @CreateTime: 2023-07-15  09:05
 * @Description: TODO
 * @Version: 1.0
 */
@Component
@Data
@ConfigurationProperties(prefix = "servers")
public class ServerConfig {
    private String ipAddress;
    private int port;
    private long timeout;
}
