package com.hf.demo.controller;

import com.hf.demo.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: demo
 * @description:测试自定义Exception
 * @author: xiehongfei
 * @create: 2021-03-02 22:27
 **/
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("user") String user) {
        if (user.equals("aaa")) {
            throw new UserNotExistException();
        }
        return "hello world";
    }
}
