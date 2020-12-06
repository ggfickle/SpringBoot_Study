package com.hf.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        System.out.println(UUID.randomUUID().toString());
        return "hello";
    }
}
