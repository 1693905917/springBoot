package com.itheima.testcase.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.testcase.domain
 * @Author: ASUS
 * @CreateTime: 2023-07-17  11:37
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "testcase.book")
public class BookCase {
    private int id;
    private String name;
    private String uuid;
    private long publishTime;
}
