package com.xhf.springboot08amqp.service;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: HelloReceiver
 * @author: xiehongfei
 * @description:
 **/
@Component
//使用queuesToDeclare可以在没有这个消息的时候创建这个队列
@RabbitListener(queuesToDeclare = @Queue(value = "hello",durable = "true", autoDelete = "false"))
public class HelloReceiver {

    /**
     * 处理消息
     *
     * @param context
     * @return void
     * @author xiehongfei
     * @date 2021/4/27 17:24
     */
    @RabbitHandler
    public void process(String context) {
        System.out.println("Receiver: " + context);
    }
}
