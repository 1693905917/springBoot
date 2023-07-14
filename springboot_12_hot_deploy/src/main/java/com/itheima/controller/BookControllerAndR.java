package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.controller
 * @Author: ASUS
 * @CreateTime: 2023-07-08  16:40
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/books")
public class BookControllerAndR {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        //return bookService.list();
        return new R(true,bookService.list());
    }
    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        boolean flag = bookService.save(book);
        if(book.getName().equals("123")) throw new IOException();
        return new R(flag,flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.modify(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable("id") Integer id){
        return new R(bookService.delete(id));
    }
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") Integer id){
        System.out.println("test hot deploy......");
        return new R(true,bookService.getById(id));
    }


    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable("currentPage") int currentPage,@PathVariable("pageSize")  int pageSize,Book book){
        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(), pageSize,book);
        }
        return new R(true, page);
    }


}
