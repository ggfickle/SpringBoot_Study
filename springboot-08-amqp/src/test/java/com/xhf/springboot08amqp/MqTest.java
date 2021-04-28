package com.xhf.springboot08amqp;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName: MqTest
 * @author: xiehongfei
 * @description:
 **/
@SpringBootTest
public class MqTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testFanout() {
        rabbitTemplate.convertAndSend("fanoutLogs", "", "Fanout发送的信息");
    }

    @Test
    public void testDirectInfor() {
        rabbitTemplate.convertAndSend("direct", "info", "发送INFO的信息");
    }

    @Test
    public void testDirectError() {
        rabbitTemplate.convertAndSend("direct", "error", "发送Error的信息");
    }

    @Test
    public void testTopic() {
        rabbitTemplate.convertAndSend("topic", "order.save.demo", "测试topic");
    }
}
