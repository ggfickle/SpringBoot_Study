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
    public void receiveMsg(Message messgae) {
        System.out.println(messgae.getBody());
        System.out.println(messgae.getMessageProperties());
        System.out.println(messgae.getClass());
    }
}
