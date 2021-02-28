package com.hf.demo.dao;

import com.hf.demo.pojo.Department;
import com.hf.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class EmploeeDao {
    //模拟数据中的数据
    private static Map<Integer, Employee> employees = null;

    //员工所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<>();
        employees.put(1001, new Employee(1001, "张三", "11@gamil.com", 0, new Department(1001, "国际部"), new Date()));
        employees.put(1002, new Employee(1002, "李四", "22@gamil.com", 1, new Department(1002, "云网部"), new Date()));
        employees.put(1003, new Employee(1003, "鲁迅", "33@gamil.com", 1, new Department(1003, "本部"), new Date()));
        employees.put(1004, new Employee(1004, "卡卡西", "44@gamil.com", 0, new Department(1004, "智慧城市部"), new Date()));
        employees.put(1005, new Employee(1005, "老番茄", "55@gamil.com", 0, new Department(1005, "智能汽车部"), new Date()));
//        ObjectOutputStream outputStream = null;
//        try {
//            File file = new File(System.getProperty("user.dir") + "/src/main/resources/static/files/employee.txt");
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            outputStream = new ObjectOutputStream(new FileOutputStream(file));
//            outputStream.writeObject(employees);
//            outputStream.close();
//            System.out.println("员工信息保存成功");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("员工信息保存失败");
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("员工信息保存失败");
//        }
    }

    //主键自增
    private static Integer initID = 1006;

    //增加一个员工
    public void addEmployee(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initID++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    //查询所有的员工信息
    public Collection<Employee> getAllEmployeeInfo() {
        return employees.values();
    }

    //根据ID查询员工信息
    public Employee getEmployeeInfoByID(Integer id) {
        return employees.get(id);
    }

    //删除一个员工
    public void deleteEmployeeById(Integer id) {
        employees.remove(id);
    }
}
