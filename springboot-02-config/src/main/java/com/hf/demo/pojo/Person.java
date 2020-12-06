package com.hf.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@ConfigurationProperties(prefix = "person") //使用yml文件匹配其中对应的内容
//@Validated //数据检验
public class Person {

    //    @NotNull
    private String name;
    //    @NotNull
    private Integer age;
    //    @NotNull
    private Boolean happy;
    //    @NotNull
    private Date birth;
    //    @NotNull
    private Map<String, Object> maps;
    //    @NotNull
    private List<Object> lists;
    //    @NotNull
    private Dog dog;
}
