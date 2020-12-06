package com.hf.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
@AllArgsConstructor
//加载指定的配置文件
@PropertySource(value = "classpath:application.properties")
public class Dog {

    @Value("${name1}")
    private String name;

    @Value("${age}")
    private Integer age;
}
