package com.hf.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hf.demo.dao.DepartmentDao;
import com.hf.demo.dao.EmploeeDao;
import com.hf.demo.pojo.Department;
import com.hf.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmploeeDao emploeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 显示所有的员工列表信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/emps")
    public String getEmployeeList(Model model) {
        Collection<Employee> allEmployeeInfo = emploeeDao.getAllEmployeeInfo();
        model.addAttribute("emps", allEmployeeInfo);
        return "emps/list";
    }

    /**
     * 转到添加员工界面
     * departments用来显示部门的下拉列表
     *
     * @param employee
     * @param model
     * @return
     */
    @GetMapping("/emp")
    public String toAddEmployee(Employee employee, Model model) {
        Collection<Department> departmentInfo = departmentDao.getDepartmentInfo();
        model.addAttribute("departments", departmentInfo);
        return "emps/add";
    }

    /**
     * 员工添加
     * springmvc自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javabean入参的对象里面的属性相同
     *
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        emploeeDao.addEmployee(employee);
        return "redirect:/emps";
    }

    /**
     * 进入员工编辑界面
     * PathVariable注解用来将{id}的值与参数id进行对应
     *
     * @param id
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = emploeeDao.getEmployeeInfoByID(id);
        model.addAttribute("employee", employee);

        //查询部门列表信息
        Collection<Department> departmentInfo = departmentDao.getDepartmentInfo();
        model.addAttribute("departments", departmentInfo);
        return "/emps/edit";
    }

    /**
     * 使用put方式更新数据
     *
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        emploeeDao.addEmployee(employee);
        System.out.println(employee);
        return "redirect:/emps";
    }

    /**
     * 使用delete的方式删除数据
     * @param id
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        emploeeDao.deleteEmployeeById(id);
        return "redirect:/emps";
    }
}
