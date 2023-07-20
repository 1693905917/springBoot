package com.itehima.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itehima.config
 * @Author: ASUS
 * @CreateTime: 2023-07-19  17:08
 * @Description: TODO
 * @Version: 1.0
 */

@Component
@ConfigurationProperties(prefix = "memcached")
@Data
public class XMemcachedProperties {
    private String servers;
    private Integer poolSize;
    private Long opTimeout;
}
