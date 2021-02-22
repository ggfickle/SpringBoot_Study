package com.hf.demo.dao;

import com.hf.demo.pojo.Department;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DepartmentDao {
    //模拟数据库中的数据

    private static List<Department> departments = null;

    static {
        departments = new ArrayList<>();
        departments.add(new Department(1001, "国际部"));
        departments.add(new Department(1002, "云网部"));
        departments.add(new Department(1003, "本部"));
        departments.add(new Department(1004, "智慧城市部"));
        departments.add(new Department(1005, "智能汽车部"));
    }

    //获取所有部门的信息
    public Object[] getDepartmentInfo() {
        return departments.toArray();
    }

    //通过ID得到部门
    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }
}
