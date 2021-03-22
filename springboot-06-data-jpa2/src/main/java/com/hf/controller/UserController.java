package com.hf.controller;

import com.hf.pojo.User;
import com.hf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot-06-data-jpa2
 * @description:
 * @author: xiehongfei
 * @create: 2021-03-19 21:11
 **/
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user = userRepository.findById(id).get();
        return user;
    }

    @GetMapping("/update")
    public User updateUser(User user){
        User update = userRepository.save(user);

        return update;
    }
}
