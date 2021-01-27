package com.hf.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class Gcsoft {
    @Value("zhansgan")
    private String name;

    @Value("12")
    private int age;

    @Value("2020/01/23")
    private Date date;
}
