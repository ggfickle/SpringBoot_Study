package com.hf.service;

import com.hf.pojo.Book;

import java.util.List;

/**
 * @program: springboot-06-data-mybatis
 * @description: book service
 * @author: xiehongfei
 * @create: 2021-03-15 22:09
 **/
public interface BookService {
    public List<Book> getAllBook();

    public Book getBook(String bookName);

    public Integer insertBook(Book book);
}
