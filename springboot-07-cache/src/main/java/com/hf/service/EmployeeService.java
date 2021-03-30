package com.hf.service;

import com.hf.pojo.Employee;

/**
 * @program: springboot-07-cache
 * @description:
 * @author: xiehongfei
 * @create: 2021-03-23 20:53
 **/
public interface EmployeeService {

    public Employee getEmployeeById(Integer employeeId);

    public Employee updateEmployee(Employee employee);

    public Integer deleteEmp(Integer id);

    public Integer insertEmp(Employee employee);

    public Employee getEmpByName(String empName);
}
