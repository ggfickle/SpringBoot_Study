package com.hf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * 扩转 SpringMvc配置    DispatcherServlet
 * 如果你想diy一些自定义的功能，只要写这个组件，然后将它交给Springboot管理(注入到Bean中)，Springboot就会帮我们自动装配！
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    //重写视图解析器，自定义一个自己的视图解析器
    //ViewResolver  实现了视图解析器接口的类  我们就可以把它叫做视图解析器
    public static class MyViewResolver implements ViewResolver {
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}
