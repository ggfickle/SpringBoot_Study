package com.hf.ticket;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、将服务提供者注册到注册中心
 * 1）：引入dubbo和zkclient相关依赖
 * 2）：配置dubbo的扫描包和注册中心地址
 * 2）：使用@service发布服务
 * @param null
 * @return
 * @author xiehongfei
 * @date 2021/4/14 17:29
 */
@SpringBootApplication
@EnableDubbo
public class ProviderTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderTicketApplication.class, args);
    }

}
