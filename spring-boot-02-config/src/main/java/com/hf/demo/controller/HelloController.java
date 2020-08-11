package com.hf.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 如果单纯获取某个数据推荐使用@value
 *
 * 如果使用配置文件注入bean推荐使用@ConfigurationProperties
 */
@RestController
public class HelloController {

    @Value("${person.lastName}")
    private String name;

    @ResponseBody
    @RequestMapping("/sayHello")
    public String hello(){
        return "hello "+name;
    }

}
