package com.hf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、引入SpringSecurity
 * 2、编写SpringSecurity的配置类，类上必须指定@EnableWebSecurity注解，且该类必须继承 WebSecurityConfigurerAdapter类
 * 3、控制请求的访问权限
 *
 * @param null 
 * @return 
 * @author xiehongfei
 * @date 2021/4/7 22:31
 */
@SpringBootApplication
public class Springboot11SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot11SecurityApplication.class, args);
    }

}
