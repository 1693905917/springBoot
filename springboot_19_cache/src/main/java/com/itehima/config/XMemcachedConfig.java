package com.itehima.config;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itehima.config
 * @Author: ASUS
 * @CreateTime: 2023-07-19  17:08
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
public class XMemcachedConfig {
    @Autowired
    private XMemcachedProperties xMemcachedProperties;
    @Bean
    public MemcachedClient getMemcachedClient() throws IOException {
        MemcachedClientBuilder builder = new XMemcachedClientBuilder(
                xMemcachedProperties.getServers());
        builder.setConnectionPoolSize(xMemcachedProperties.getPoolSize());
        builder.setConnectTimeout(xMemcachedProperties.getOpTimeout());
        MemcachedClient memcachedClient = builder.build();
        return memcachedClient;
    }

}
