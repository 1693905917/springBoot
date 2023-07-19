package com.itehima.service;

import com.itehima.domain.Book;

import java.util.List;

public interface BookService {
    public boolean save(Book book);
    public Book getById(Integer id);
    public boolean update(Book book);
    public boolean delete(Integer id);
    public List<Book> getAll();
}
