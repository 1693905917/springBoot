package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.Book;

public interface IBookService extends IService<Book> {

    Boolean delete(Integer id);

    Boolean modify(Book book);

    IPage<Book> getPage(int currentPage,int pageSize);

}
