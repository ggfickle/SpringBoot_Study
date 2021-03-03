package com.hf.demo.exception;

/**
 * @program: demo
 * @description: 自定义异常类
 * @author: xiehongfei
 * @create: 2021-03-02 22:25
 **/
public class UserNotExistException extends RuntimeException{

    public UserNotExistException() {
        super("用户不存在");
    }
}
