package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.service.impl
 * @Author: ASUS
 * @CreateTime: 2023-07-17  11:05
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public boolean save(Book book) {
        return bookDao.insert(book)>0;
    }
}
