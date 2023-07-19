package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
class Springboot16RedisApplicationTests {
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void set() {
        ValueOperations vo = redisTemplate.opsForValue();
        vo.set("age",41);
    }

    @Test
    void get() {
        ValueOperations vo = redisTemplate.opsForValue();
        Object age = vo.get("name");
        System.out.println(age);//41
    }
    @Test
    void hset() {
        HashOperations ho = redisTemplate.opsForHash();
        ho.put("info","a","aa");

    }
    @Test
    void hget() {
        HashOperations ho = redisTemplate.opsForHash();
        Object o = ho.get("info", "a");
        System.out.println(o);//aa
    }


}
