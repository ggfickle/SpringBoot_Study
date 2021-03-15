package com.hf.mapper;

import com.hf.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: springboot-06-data-mybatis
 * @description: bookMapper
 * @author: xiehongfei
 * @create: 2021-03-15 21:53
 **/
@Mapper
public interface BookMapper {

    public List<Book> getAllBook();

    public Book getBook(String bookName);

    public Integer insertBook(Book book);
}
