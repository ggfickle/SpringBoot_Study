package com.hf.demo.controller;

import com.hf.demo.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description: 异常处理器
 * @author: xiehongfei
 * @create: 2021-03-02 22:35
 **/
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 此时访问浏览器的时候返回的也是Json数据
     *
     * @param e
     * @return
     */
//    @ResponseBody
////    @ExceptionHandler(UserNotExistException.class)
////    public Map<String, Object> handlerException(Exception e) {
////        Map<String, Object> map = new HashMap<>();
////        map.put("code", "user.notExist");
////        map.put("message", e.getMessage());
////        return map;
////    }
    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "user.notExist");
        map.put("message","用户出错了");
        request.setAttribute("javax.servlet.error.status_code",400);
        request.setAttribute("ext",map);
        //转发到/error请求
        return "forward:/error";
    }
}
