package com.xhf.springboot08amqp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springboot-08-amqp
 * @description: 可在测试类中查看具体的创建队列的方法
 * @author: xiehongfei
 * @create: 2021-04-06 15:39
 **/
@Configuration
public class MyAmqpConfig {

    /**
     * 自定义messageConverter使用JSON的格式来序列化
     *
     * @return
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    //定义一个名称为hello的队列
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    @Bean
    public Queue xhfEmps() {
        return new Queue("xhf.emps");
    }

    @Bean
    public Queue xhfNews() {
        return new Queue("xhf.news");
    }
}
