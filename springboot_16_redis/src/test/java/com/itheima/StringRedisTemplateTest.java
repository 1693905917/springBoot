package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima
 * @Author: ASUS
 * @CreateTime: 2023-07-17  21:36
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest
public class StringRedisTemplateTest {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Test
    void get(){
        ValueOperations<String, String> vo = stringRedisTemplate.opsForValue();
        String name = vo.get("name");
        System.out.println(name);
    }


}
