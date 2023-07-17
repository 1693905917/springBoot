package com.itheima.controller;

import com.itheima.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.controller
 * @Author: ASUS
 * @CreateTime: 2023-07-17  09:23
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public Book getById(){
        System.out.println("getById is running....");
        Book book = new Book(1,"springboot"
                ,"springboot","springboot");
        return book;
        //响应体：{"id":1,"name":"springboot","type":"springboot",
        // "description":"springboot"}
    }

}
