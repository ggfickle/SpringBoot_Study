package com.hf.service;

import com.hf.pojo.Department;

/**
 * @program: springboot-07-cache
 * @description:
 * @author: xiehongfei
 * @create: 2021-03-23 20:54
 **/
public interface DepartmentService {
    public Department getDepartmentById(Integer departmentId);

    public void insertDept(Department department);
}
