package com.hf.service;

import com.hf.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: springboot-06-data-mybatis
 * @description: user service
 * @author: xiehongfei
 * @create: 2021-03-15 20:53
 **/

public interface UserService {

    public List<User> selectAllUser();

    public User selectUserById(Integer id);

    public Integer insertUser(User user);

    public Integer deleteUserByUserName(User user);

    public Integer updateUserByUserName(User user);
}
