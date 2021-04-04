package com.hf.controller;

import com.hf.pojo.Department;
import com.hf.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * @program: springboot-07-cache
 * @description:
 * @author: xiehongfei
 * @create: 2021-04-04 21:46
 **/
@Slf4j
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/{deptId}")
    public Department getDeptById(@PathVariable("deptId") Integer deptId) {
        log.info("getDepartmentById。。。。"+ LocalDate.now());
        Department department = departmentService.getDepartmentById(deptId);
        return department;
    }
}
