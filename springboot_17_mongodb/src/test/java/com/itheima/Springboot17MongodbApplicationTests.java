package com.itheima;

import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class Springboot17MongodbApplicationTests {
    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    void testSave() {
        Book book = new Book();
        book.setId(2);
        book.setType("springboot2");
        book.setName("springboot2");
        book.setDescription("springboot2");
        mongoTemplate.save(book);
    }
    @Test
    void testFind() {
        List<Book> all = mongoTemplate.findAll(Book.class);
        System.out.println(all);
    }


}
