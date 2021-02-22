package com.hf.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @program: springboot-05-EmployeeManagement
 * @description: login
 * @author: xiehongfei
 * @create: 2021-02-15 17:40
 **/

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        if (!StringUtils.isEmpty("username") && password.equals("123")) {
            session.setAttribute("userSession", username);
            return "redirect:main.html";
        } else {
            model.addAttribute("msg", "用户名或者密码错误！");
        }
        return "index";
    }
}
