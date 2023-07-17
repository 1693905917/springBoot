package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima
 * @Author: ASUS
 * @CreateTime: 2023-07-15  15:32
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest
public class PropertiesAndArgsTest {
    @Value("${test.prop}")
    private String msg;

    @Test
    public void testProperties(){
        System.out.println(msg);
    }
}
