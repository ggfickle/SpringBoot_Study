package com.hf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class TestController {

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("msg", "<h2>Hello Springboot!<h2>");
        model.addAttribute("users", Arrays.asList("<h3>zhangsan</h3>", "<h3>lisi</h3>"));
        return "Test";
    }

}
