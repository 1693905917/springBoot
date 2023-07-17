package com.itheima;

import com.itheima.config.MsgConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima
 * @Author: ASUS
 * @CreateTime: 2023-07-17  08:46
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest
@Import({MsgConfig.class})
public class ConfigurationTest {
    @Autowired
    private String msg;

    @Test
    public void testConfiguration(){
        System.out.println(msg);
    }
}
