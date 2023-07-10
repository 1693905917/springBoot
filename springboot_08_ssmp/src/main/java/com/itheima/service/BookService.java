package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;

import java.util.List;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.service
 * @Author: ASUS
 * @CreateTime: 2023-07-08  15:05
 * @Description: TODO
 * @Version: 1.0
 */
public interface BookService {
    /*
     * @description:存储书籍信息
     * @author:  HZP
     * @date: 2023/7/8 15:10
     * @param:
     * @return:
     **/
    boolean save(Book book);
    /*
     * @description:通过ID删除书籍信息
     * @author:  HZP
     * @date: 2023/7/8 15:11
     * @param:
     * @return:
     **/
    boolean delete(Integer id);
    /*
     * @description:更新数据信息
     * @author:  HZP
     * @date: 2023/7/8 15:11
     * @param:
     * @return:
     **/
    boolean update(Book book);
    /*
     * @description:通过ID查询并返回书籍信息
     * @author:  HZP
     * @date: 2023/7/8 15:11
     * @param:
     * @return:
     **/
    Book getById(Integer id);
    /*
     * @description:查询全部书籍信息
     * @author:  HZP
     * @date: 2023/7/8 15:11
     * @param:
     * @return:
     **/
    List<Book> getAll();
    /*
     * @description:分页模糊查询
     * @author:  HZP
     * @date: 2023/7/8 15:12
     * @param:
     * @return:
     **/
    IPage<Book> getByPage(int currentPage, int pageSize);

}
