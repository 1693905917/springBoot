package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.service.impl
 * @Author: ASUS
 * @CreateTime: 2023-07-08  15:43
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class IBookServiceImpl extends ServiceImpl<BookDao,Book> implements IBookService{
    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id)>0;
    }

    @Override
    public Boolean modify(Book book) {
        return bookDao.updateById(book)>0;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        Page<Book> page = new Page<>(currentPage, pageSize);
        bookDao.selectPage(page,null);
        return page;
    }


}
