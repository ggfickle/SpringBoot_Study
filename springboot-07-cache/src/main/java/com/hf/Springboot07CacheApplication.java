package com.hf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


//@MapperScan指定需要扫描的mapper接口所在的包

/**
 * 整合redis作为缓存
 * 原理：CacheManager创造出Cache这个缓存组件来实际给缓存中存储数据
 * 1、引入redis的starter，容器中保存的是RedisCacheManager
 * 2、RedisCacheManager通过createRedisCache创建RedisCache对象来作为缓存组件，RedisCache是通过redis缓存数据的
 */
@MapperScan("com.hf.mapper")
@SpringBootApplication
@EnableCaching   //开启基于注解的缓存
public class Springboot07CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot07CacheApplication.class, args);
    }

}
