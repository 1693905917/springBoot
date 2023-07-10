package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class IBookServiceTestCase {
    @Autowired
    private IBookService bookService;

    @Test
    void save() {
        Book book = new Book();
        book.setName("测试数据123");
        book.setType("测试类型123");
        book.setDescription("测试描述数据123");
        bookService.save(book);
    }

    @Test
    void delete() {
        bookService.removeById(17);
    }

    @Test
    void update() {
        Book book = new Book();
        book.setId(16);
        book.setName("测试数据12");
        book.setType("测试类型a12");
        book.setDescription("测试描述数据abc");
        bookService.updateById(book);
    }

    @Test
    void getById() {
        bookService.getById(1);
    }

    @Test
    void getAll() {
        bookService.list();
    }

    @Test
    void getByPage() {
        IPage<Book> bookIPage=new Page<>(2,5);
        bookService.page(bookIPage);
    }

}