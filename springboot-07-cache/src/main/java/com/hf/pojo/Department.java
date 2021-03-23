package com.hf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: springboot-07-cache
 * @description:
 * @author: xiehongfei
 * @create: 2021-03-23 20:03
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private String departmentId;

    private String departmentName;
}
