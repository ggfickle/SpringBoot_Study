package com.hf.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hf.demo.dao.EmploeeDao;
import com.hf.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmploeeDao emploeeDao;

    @RequestMapping("/emps")
    public String getEmployeeList(Model model) {
        Collection<Employee> allEmployeeInfo = emploeeDao.getAllEmployeeInfo();
        model.addAttribute("emps", allEmployeeInfo);
        return "emps/list";
    }
}
