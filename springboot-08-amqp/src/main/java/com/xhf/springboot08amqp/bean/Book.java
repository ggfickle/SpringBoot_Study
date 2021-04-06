package com.xhf.springboot08amqp.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: springboot-08-amqp
 * @description:
 * @author: xiehongfei
 * @create: 2021-04-06 15:49
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
    private String bookName;
    private double price;
}
