package com.itheima.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.controller
 * @Author: ASUS
 * @CreateTime: 2023-07-05  10:03
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    //private static final Logger log= LoggerFactory.getLogger(BookController.class);
    @GetMapping
    public String getById(){
        System.out.println("springboot is running....");
        log.debug("debug...");
        log.info("info...");
        log.warn("warn...");
        log.error("error...");
        return "springboot is running....";
    }
}
