package com.hf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @program: springboot-06-data-jpa2
 * @description: user pojo
 * @author: xiehongfei
 * @create: 2021-03-19 21:01
 **/
@Entity
@Table(name = "table_jpa")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column
    private String password;
}
