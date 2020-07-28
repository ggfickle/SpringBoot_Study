package com.hf.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot_01_helloworld_qickly
 * @description: 添加controller接口
 * @author: Mr.Wang
 * @create: 2020-07-28 23:15
 **/
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world quickly";
    }
}
