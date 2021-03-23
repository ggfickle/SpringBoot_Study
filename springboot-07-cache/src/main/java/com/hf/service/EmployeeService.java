package com.hf.service;

import com.hf.pojo.Department;
import com.hf.pojo.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @program: springboot-07-cache
 * @description:
 * @author: xiehongfei
 * @create: 2021-03-23 20:53
 **/
public interface EmployeeService {

    public Employee getEmployeeById(Integer employeeId);

    public void updateEmployee(Employee employee);

    public void deleteEmp(Integer id);

    public void insertEmp(Employee employee);
}
