package com.hf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: springboot-06-data-mybatis
 * @description: book pojo
 * @author: xiehongfei
 * @create: 2021-03-15 21:58
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer bookId;
    private String bookName;
    private double bookPrice;
}
