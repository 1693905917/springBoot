package com.itheima.contorller;

import com.itheima.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private MyDataSource myDataSource;

    @GetMapping
    public String getById(){
        System.out.println("springboot is running....yaml");
        System.out.println("MyDataSource++++>"+myDataSource);
        return "springboot is running....yaml";
    }
}
