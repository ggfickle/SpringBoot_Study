package com.hf.service.impl;

import com.hf.mapper.UserMapper;
import com.hf.pojo.User;
import com.hf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: springboot-06-data-mybatis
 * @description: user service 实现类
 * @author: xiehongfei
 * @create: 2021-03-15 20:54
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public Integer deleteUserByUserName(User user) {
        return userMapper.deleteUserByUserName(user);
    }

    @Override
    public Integer updateUserByUserName(User user) {
        return userMapper.updateUserByUserName(user);
    }
}
