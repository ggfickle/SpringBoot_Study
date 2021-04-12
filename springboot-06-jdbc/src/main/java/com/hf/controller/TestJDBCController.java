package com.hf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: springboot--06-jdbc
 * @description: test Conteoller
 * @author: xiehongfei
 * @create: 2021-03-14 14:47
 **/
@RestController
public class TestJDBCController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/hello")
    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from company");
        return maps;
    }
}
