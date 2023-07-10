package com.itheima.service;

import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookServiceTestCase {
    @Autowired
    private BookService bookService;

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
        bookService.delete(15);
    }

    @Test
    void update() {
        Book book = new Book();
        book.setId(16);
        book.setName("测试数据abc");
        book.setType("测试类型abc");
        book.setDescription("测试描述数据abc");
        bookService.update(book);
    }

    @Test
    void getById() {
        bookService.getById(1);
    }

    @Test
    void getAll() {
        bookService.getAll();
    }

    @Test
    void getByPage() {
        bookService.getByPage(1,5);
    }
}