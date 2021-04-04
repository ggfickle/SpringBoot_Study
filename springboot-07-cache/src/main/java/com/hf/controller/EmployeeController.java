package com.hf.controller;

import com.hf.pojo.Employee;
import com.hf.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot-07-cache
 * @description:
 * @author: xiehongfei
 * @create: 2021-03-23 21:11
 **/
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/emp/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") Integer employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return employee;
    }

    @GetMapping("/updateemp")
    public Employee updateEmp(Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/delemp/{id}")
    public String delEmp(@PathVariable("id") Integer id) {
        return employeeService.deleteEmp(id) == 0 ? "fail" : "Success";
    }

    @GetMapping("/emp/empname/{empname}")
    public Employee getEmpByName(@PathVariable("empname") String empName){
        return employeeService.getEmpByName(empName);
    }
}
