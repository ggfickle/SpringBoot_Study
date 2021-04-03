package com.hf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: springboot-07-cache
 * @description:
 * @author: xiehongfei
 * @create: 2021-03-23 20:00
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    private Integer employeeId;

    private String employeeName;

    private String employeeEmail;

    private Integer employeeGender;//1 男  0 女

    private Integer dId;
}
