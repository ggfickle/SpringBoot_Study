package com.xhf.springboot08amqp.config;

import org.springframework.amqp.support.converter.AbstractJackson2MessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springboot-08-amqp
 * @description: AMQP Config
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
}
