package com.itheima.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.bean
 * @Author: ASUS
 * @CreateTime: 2023-07-24  15:37
 * @Description: TODO
 * @Version: 1.0
 */
//@Component
@Data
@ConfigurationProperties(prefix = "cartoon")
public class CartoonProperties {
    private Cat cat;
    private Mouse mouse;
}
