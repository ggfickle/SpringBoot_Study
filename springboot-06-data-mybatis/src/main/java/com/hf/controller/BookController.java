package com.hf.controller;

import com.alibaba.fastjson.JSONObject;
import com.hf.pojo.Book;
import com.hf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: springboot-06-data-mybatis
 * @description: BookController
 * @author: xiehongfei
 * @create: 2021-03-15 22:08
 **/
@RestController
@RequestMapping("/book")
public class BookController {

    private JSONObject jsonObject;

    @Autowired
    private BookService bookService;

    @GetMapping("/getAllBook")
    public String getAllBook() {
        List<Book> allBook = bookService.getAllBook();
        jsonObject = new JSONObject();
        jsonObject.put("books", allBook);
        return jsonObject.toJSONString();
    }

    @GetMapping("/getBook/{bookName}")
    public String getBook(@PathVariable("bookName") String bookName) {
        Book book = bookService.getBook(bookName);
        jsonObject = new JSONObject();
        jsonObject.put("book", book);
        return jsonObject.toJSONString();
    }

    @GetMapping("/insertBook")
    public String insertBook(Book book) {
        Integer integer = bookService.insertBook(book);
        jsonObject = new JSONObject();
        jsonObject.put("Status", integer > 0 ? "插入数据成功" : "插入数据失败");
        return jsonObject.toJSONString();
    }
}
