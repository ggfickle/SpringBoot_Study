package com.hf.service.impl;

import com.hf.mapper.DepartmentMapper;
import com.hf.pojo.Department;
import com.hf.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: springboot-07-cache
 * @description:
 * @author: xiehongfei
 * @create: 2021-03-23 20:55
 **/
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Department getDepartmentById(Integer departmentId) {
        logger.debug("getDepartmentById。。。");
        System.out.println("getDepartmentById。。。。");
        return departmentMapper.getDepartmentById(departmentId);
    }

    @Override
    public void insertDept(Department department) {
        logger.trace("insertDept。。。");
        departmentMapper.insertDept(department);
    }
}
