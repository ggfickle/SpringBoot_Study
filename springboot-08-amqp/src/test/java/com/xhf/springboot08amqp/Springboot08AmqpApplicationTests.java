package com.xhf.springboot08amqp;

import com.xhf.springboot08amqp.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Springboot08AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    /**
     * 单播（点对点）
     */
    @Test
    void contextLoads() {
        // Message 需要自己构造一个；定义消息体内容和消息头
        // rabbitTemplate.send(exchange, routeKey, message);

        // Object默认当成消息体，只需要传入发送的对象，自动序列化发送给RabbitMQ
        // rabbitTemplate.convertAndSend(exchange, routeKey, object);

        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("helloworld", 123, true));
        //对象被默认序列化以后发送出去
//        rabbitTemplate.convertAndSend("exchange.direct", "xhf.emps", map);
        rabbitTemplate.convertAndSend("exchange.direct", "xhf.emps", new Book("西游记", 19.80));
    }

    /**
     * 测试点对点接收消息
     */
    @Test
    public void receive() {
        // receive: 传入队列参数,将接收的消息自动转化成Message的格式，包含消息头和消息体
//        Message message = rabbitTemplate.receive("xhf.emps");
//        System.out.println(message);


        // receiveAndConvert:传入队列参数，将接收的消息自动转化成我们所需要的内容对象
        // 可进行格式的转换
//        Book o = (Book)rabbitTemplate.receiveAndConvert("xhf.emps");
        Object o = rabbitTemplate.receiveAndConvert("xhf.emps");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播
     */
    @Test
    public void sendMsg() {
        //广播模式下无需指定路由键，因为所有的队列都能接收到消息
        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("茶馆", 90.1));
    }

    /**
     * 使用注解创建队列、交换机和绑定
     */
    @Test
    public void create() {
        amqpAdmin.declareQueue(new Queue("amqp.queue"));//创建队列
        System.out.println("队列创建成功");
        amqpAdmin.declareExchange(new DirectExchange("ampq.exchage"));//创建直连型交换机
        System.out.println("交换机创建成功");
        amqpAdmin.declareBinding(new Binding("amqp.queue",
                Binding.DestinationType.QUEUE, "ampq.exchage", "amqp", null));//绑定信息
        System.out.println("队列与交换机的绑定创建成功");
    }

    @Test
    public void createExchange() {
        // DirectExchange、FanoutExchange、CustomExchange、TopicExchange、HeadersExchange
        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange", true, false));
        System.out.println("amqpAdmin.exchange创建完成");
        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue", true));
        System.out.println("amqpAdmin.queue创建完成");
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue", Binding.DestinationType.QUEUE, "amqpAdmin.exchange", "amqp.haha", null));
        System.out.println("Binding绑定完成");
    }

}
