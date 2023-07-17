package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.dao
 * @Author: ASUS
 * @CreateTime: 2023-07-08  10:05
 * @Description: TODO
 * @Version: 1.0
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {

}
