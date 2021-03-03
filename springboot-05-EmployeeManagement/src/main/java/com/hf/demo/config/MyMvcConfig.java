package com.hf.demo.config;

import com.hf.demo.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: springboot-05-EmployeeManagement
 * @description: My MVC Config
 * @author: xiehongfei
 * @create: 2021-02-15 17:37
 **/

//扩展MVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/notfound").setViewName("notFound");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //自定义的国际化组件就生效了
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResolver();
    }

    //自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePaths = new ArrayList<>();
        excludePaths.add("/logout");
        excludePaths.add("/index");
        excludePaths.add("/");
        excludePaths.add("/login");
        excludePaths.add("/css/*");
        excludePaths.add("/img/*");
        excludePaths.add("/js/*");
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePaths);
    }
}
