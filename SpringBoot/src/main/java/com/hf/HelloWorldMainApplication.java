package com.hf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication来标注一个主程序类，说明这是一个是springboot应用
 */
@SpringBootApplication
public class HelloWorldMainApplication {

    public static void main(String[] args) {

        //spring应用启动
        SpringApplication.run(HelloWorldMainApplication.class,args);
    }
}
