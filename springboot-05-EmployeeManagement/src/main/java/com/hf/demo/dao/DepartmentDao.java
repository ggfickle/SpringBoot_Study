package com.hf.demo.dao;

import com.hf.demo.pojo.Department;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Component
public class DepartmentDao {
    //模拟数据库中的数据

    private static Map<Integer, Department> departments = null;

    static {
        ObjectOutputStream outputStream = null;
        departments = new HashMap<>();
        departments.put(1001, new Department(1001, "国际部"));
        departments.put(1002, new Department(1002, "云网部"));
        departments.put(1003, new Department(1003, "本部"));
        departments.put(1004, new Department(1004, "智慧城市部"));
        departments.put(1005, new Department(1005, "智能汽车部"));
//        try {
//            File file = new File(System.getProperty("user.dir") + "/src/main/resources/static/files/deparement.txt");
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            outputStream = new ObjectOutputStream(new FileOutputStream(file));
//            outputStream.writeObject(departments);
//            outputStream.close();
//            System.out.println("部门信息保存成功");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("部门信息保存失败");
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("部门信息保存失败");
//        }
    }

    //获取所有部门的信息
    public Collection<Department> getDepartmentInfo() {
        return departments.values();
    }

    //通过ID得到部门
    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }
}
