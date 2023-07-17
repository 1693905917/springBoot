package com.itheima;

import com.itheima.domain.Book;
import com.itheima.service.BookService;
import com.itheima.testcase.domain.BookCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima
 * @Author: ASUS
 * @CreateTime: 2023-07-17  11:06
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest
@Transactional
@Rollback(value = false)
public class DaoTest {

    @Autowired
    private BookCase bookCase;

    @Test
    void testBookCase(){
        System.out.println(bookCase);
    }

    @Autowired
    private BookService bookService;
    @Test
    void test(){
        Book book = new Book();
        book.setName("springBook3");
        book.setType("springBook3");
        book.setDescription("springBook3");
        bookService.save(book);
    }
}
