package com.hf.service.impl;

import com.hf.mapper.BookMapper;
import com.hf.pojo.Book;
import com.hf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: springboot-06-data-mybatis
 * @description: book Service Impl
 * @author: xiehongfei
 * @create: 2021-03-15 22:10
 **/
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getAllBook() {
        return bookMapper.getAllBook();
    }

    @Override
    public Book getBook(String bookName) {
        return bookMapper.getBook(bookName);
    }

    @Override
    public Integer insertBook(Book book) {
        return bookMapper.insertBook(book);
    }
}
