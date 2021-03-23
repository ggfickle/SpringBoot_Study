package com.hf;

import com.hf.mapper.DepartmentMapper;
import com.hf.pojo.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot07CacheApplicationTests {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    void contextLoads() {
        Department department = departmentMapper.getDepartmentById(1);
        System.out.println(department);
    }

}
