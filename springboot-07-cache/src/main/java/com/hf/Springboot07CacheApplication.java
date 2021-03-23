package com.hf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


//@MapperScan指定需要扫描的mapper接口所在的包
@MapperScan("com.hf.mapper")
@SpringBootApplication
@EnableCaching
public class Springboot07CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot07CacheApplication.class, args);
    }

}
