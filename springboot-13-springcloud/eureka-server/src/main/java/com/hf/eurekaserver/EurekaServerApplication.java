package com.hf.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心
 * 1、配置eureka信息
 * 2、使用@EnableEurekaServer来启用我们注册中心的功能
 *
 *
 * @param null
 * @return
 * @author xiehongfei
 * @date 2021/4/14 20:19
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}
