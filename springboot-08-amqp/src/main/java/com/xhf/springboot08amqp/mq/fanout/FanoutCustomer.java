package com.xhf.springboot08amqp.mq.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: FanoutCustomer
 * @author: xiehongfei
 * @description:
 **/
@Component
public class FanoutCustomer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 创建临时队列
                    exchange = @Exchange(type = "fanout", value = "fanoutLogs") // 绑定的交换机
            )
    })
    public void receive1(String message) {
        System.out.println("message1: " + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 创建临时队列
                    exchange = @Exchange(type = "fanout", value = "fanoutLogs") // 绑定的交换机
            )
    })
    public void receive2(String message) {
        System.out.println("message2: " + message);
    }
}
