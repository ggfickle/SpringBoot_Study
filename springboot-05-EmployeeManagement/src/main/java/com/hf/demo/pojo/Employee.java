package com.hf.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 员工表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    
    private static final long serialVersionUID = 1L;
    //ID
    private Integer id;

    //姓名
    private String employeeName;

    //Email
    private String email;

    //性别
    private Integer gender;//1:女  2：男

    //部门
    private Department department;

    //出生年月
    //如果不加DateTimeFormat注解，前端date控件传过来的参数无法接收到，格式转化不成功,也可在配置文件中添加date-format配置项进行更改
    //@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date birth;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(employeeName, employee.employeeName) &&
                Objects.equals(email, employee.email) &&
                Objects.equals(gender, employee.gender) &&
                Objects.equals(department, employee.department) &&
                Objects.equals(birth, employee.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeName, email, gender, department, birth);
    }
}
