package com.xhf.springboot08amqp.service;

import com.xhf.springboot08amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.stereotype.Service;

/**
 * @program: springboot-08-amqp
 * @description:
 * @author: xiehongfei
 * @create: 2021-04-06 16:05
 **/
@Service
public class BookService {

    @RabbitListener(queues = "xhf.emps")
    public void receive(Book book) {
        System.out.println("接收到了：" + book);
    }

    @RabbitListener(queues = "xhf.news")
    public void receiveMsg(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
        System.out.println(message.getClass());
    }
}
