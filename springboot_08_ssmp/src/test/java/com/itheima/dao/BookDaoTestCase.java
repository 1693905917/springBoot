package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.dao
 * @Author: ASUS
 * @CreateTime: 2023-07-08  10:09
 * @Description: TODO
 * @Version: 1.0
 */

@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById(){
        bookDao.selectById(1);
    }

    @Test
    public void testSave(){
        Book book = new Book();
        book.setName("测试数据");
        book.setType("测试类型");
        book.setDescription("测试描述数据");
        bookDao.insert(book);
    }

    @Test
    void testSelectAll(){
        //如果要查询全部，selectList方法的参数需要设置为了null即可
        bookDao.selectList(null);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(15);
        book.setName("黑盒测试");
        book.setType("测试类型");
        book.setDescription("测试描述数据");
        bookDao.updateById(book);
    }

    @Test
    void testGetPage(){
        IPage page = new Page(1,5);
        bookDao.selectPage(page,null);

    }

    @Test
    void testGetByCondition(){
        QueryWrapper<Book> qw=new QueryWrapper<>();
        qw.like("name","Spring");
        bookDao.selectList(qw);
    }

    @Test
    void testGetByCondition2(){
        String name="Spring";
        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<>();
        lqw.like(name!=null,Book::getName,name);
        bookDao.selectList(lqw);
    }


}
