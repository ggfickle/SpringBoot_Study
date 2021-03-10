package com.hf.demo.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: demo
 * @description: 过滤器
 * @author: xiehongfei
 * @create: 2021-03-10 20:16
 **/
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter Process.....");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
