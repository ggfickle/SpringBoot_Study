package com.xhf.springboot08amqp.compent;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: HelloSender
 * @author: xiehongfei
 * @description: 生产者，AmqpTemplate是springboot 提供的默认实现
 **/
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String queueName, String message) {
        rabbitTemplate.convertAndSend(queueName, message);
    }
}
