package com.xhf.springboot08amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 * 1、RabbitAutoConfiguration
 * 2、有自动配置了连接工厂：connectionFactory
 * 3、RabbitProperties封装了RabbitMQ的所有配置
 * 4、RabbitTemplate：给rabbitMQ发送和接受消息
 * 5、AmqpAdmin: RabbitMQ系统管理功能组件
 *  AmqpAdmin：创建和删除queue、exchange、binding
 * 6、@EnableRabbit + @RabbitListener 监听消息队列的内容
 */
@EnableRabbit //开启基于注解的RabbitMq
@SpringBootApplication
public class Springboot08AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot08AmqpApplication.class, args);
    }

}
