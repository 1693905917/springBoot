package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public R save(@RequestBody Book book){
        return new R(bookService.save(book));
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
        return new R(true,bookService.getById(id));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable("currentPage") int currentPage,@PathVariable("pageSize")  int pageSize){
        return new R(true,bookService.getPage(currentPage,pageSize));
    }


}
