package com.hf.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 员工表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    //ID
    private Integer id;

    //姓名
    private String name;

    //Email
    private String email;

    //性别
    private Integer gender;//0:女  1：男

    //部门
    private Department department;

    //出生年月
    private Date birth;
}
