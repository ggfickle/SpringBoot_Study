package com.hf.service.impl;

import com.hf.mapper.DepartmentMapper;
import com.hf.pojo.Department;
import com.hf.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @program: springboot-07-cache
 * @description:
 * @author: xiehongfei
 * @create: 2021-03-23 20:55
 **/

@Service
@CacheConfig(cacheNames = "dept",cacheManager = "myCacheManager")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Cacheable(key = "#departmentId")
    @Override
    public Department getDepartmentById(Integer departmentId) {
        System.out.println("getDepartmentById。。。。");
        return departmentMapper.getDepartmentById(departmentId);
    }

    @Override
    public void insertDept(Department department) {
        departmentMapper.insertDept(department);
    }
}
