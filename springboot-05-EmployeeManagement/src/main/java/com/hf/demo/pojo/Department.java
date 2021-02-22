package com.hf.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 部门表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    //部门ID
    private Integer id;

    //部门名称
    private String departmentName;
}
