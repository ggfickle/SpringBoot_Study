package com.hf.demo.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.EventListener;

/**
 * @program: springboot-05-EmployeeManagement
 * @description:
 * @author: xiehongfei
 * @create: 2021-03-11 21:47
 **/
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized....web应用启动了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed....web应用销毁了");
    }
}
