package com.hf.config;

import com.hf.pojo.Department;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @program: springboot-07-cache
 * @description:
 * @author: xiehongfei
 * @create: 2021-03-31 21:20
 **/
@Configuration
public class MyRedisConfig {
    @Bean
    public RedisTemplate<Object, Object> empRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Object> employeeJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        template.setDefaultSerializer(employeeJackson2JsonRedisSerializer);
        //解决添加key的时候有双引号的问题
        template.setKeySerializer(new StringRedisSerializer());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(employeeJackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}
