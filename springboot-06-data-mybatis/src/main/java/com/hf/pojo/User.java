package com.hf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: springboot-06-data-mybatis
 * @description: user
 * @author: xiehongfei
 * @create: 2021-03-15 20:21
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
}
