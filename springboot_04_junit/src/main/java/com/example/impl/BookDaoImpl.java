package com.example.impl;

import com.example.BookDao;
import org.springframework.stereotype.Repository;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.example.dao
 * @Author: ASUS
 * @CreateTime: 2023-07-07  15:00
 * @Description: TODO
 * @Version: 1.0
 */
@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao is running....");
    }
}
