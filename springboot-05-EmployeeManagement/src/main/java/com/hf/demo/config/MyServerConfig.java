package com.hf.demo.config;

import com.hf.demo.servlet.MyFilter;
import com.hf.demo.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @program: demo
 * @description: 服务器配置
 * @author: xiehongfei
 * @create: 2021-03-10 20:01
 **/
@Configuration
public class MyServerConfig {

    //注册三大组件

    /**
     * 注册Servlet
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean<MyServlet> myServletRegistrationBean() {
        ServletRegistrationBean<MyServlet> myServletServletRegistrationBean = new ServletRegistrationBean<>(new MyServlet(), "/myServlet");
        return myServletServletRegistrationBean;
    }

    /**
     * 注册过滤器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean<MyFilter> myFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello", "/MyServlet", "/hello1"));
        return filterRegistrationBean;
    }

    /**
     * 配置嵌入式的Servlet的容器
     *
     * @return
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        //  定制嵌入式的Servlet容器相关的规则
        return factory -> factory.setPort(8080);
    }
}
