package com.hf.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @program: springboot-07-cache
 * @description: 缓存配置类
 * @author: xiehongfei
 * @create: 2021-03-29 22:26
 **/
@Configuration
public class CacheConfig {

    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator(){
        return new KeyGenerator(){
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName().concat("[").concat(Arrays.asList(objects).toString()).concat("]");
            }
        };
    }
}
