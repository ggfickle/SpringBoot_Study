package com.xhf.springboot08amqp.mq.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: TopicCustomer
 * @author: xiehongfei
 * @description:
 **/
@Component
public class TopicCustomer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "topic", type = "topic"),
                    key = {"user.save", "user.*"}
            )
    })
    private void receive1(String message) {
        System.out.println("message1: " + message);
    }

    // #代表多个字符   *代表一个字符
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "topic", type = "topic"),
                    key = {"order.#", "user.*"}
            )
    })
    private void receive2(String message) {
        System.out.println("message2: " + message);
    }
}
