package com.hf.controller;

import com.alibaba.fastjson.JSONObject;
import com.hf.pojo.User;
import com.hf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: springboot-06-data-mybatis
 * @description: user controller
 * @author: xiehongfei
 * @create: 2021-03-15 20:56
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private JSONObject json;

    @GetMapping("/getAllUser")
    public String getAllUser() {
        List<User> users = userService.selectAllUser();
        json = new JSONObject();
        json.put("users", users);
        return json.toJSONString();
    }

    @GetMapping("/getUser/{id}")
    public String selectUserById(@PathVariable("id") Integer id) {
        User user = userService.selectUserById(id);
        json = new JSONObject();
        json.put("user", user);
        return json.toJSONString();
    }

    @GetMapping("/insertUser")
    public String insertUser(User user) {
        Integer integer = userService.insertUser(user);
        json = new JSONObject();
        json.put("Status", integer > 0 ? "插入数据成功" : "插入数据失败");
        return json.toJSONString();
    }

    @GetMapping("/deleteUser")
    public String deleteUserByUserName(User user) {
        Integer integer = userService.deleteUserByUserName(user);
        json = new JSONObject();
        json.put("Status", integer > 0 ? "删除数据成功" : "删除数据失败");
        return json.toJSONString();
    }

    @GetMapping("/updateUser")
    public String updateUserByUserName(User user) {
        Integer integer = userService.updateUserByUserName(user);
        json = new JSONObject();
        json.put("Status", integer > 0 ? "更新数据成功" : "更新数据失败");
        return json.toJSONString();
    }
}
