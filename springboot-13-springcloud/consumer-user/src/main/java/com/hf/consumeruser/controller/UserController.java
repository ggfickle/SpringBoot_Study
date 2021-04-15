package com.hf.consumeruser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: UserController
 * @author: xiehongfei
 * @description:
 **/
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/buy")
    public String getMessage(String name) {
        String object = restTemplate.getForObject("http://provider-ticket/ticket", String.class);
        return name + "购买了" + object;
    }
}
