package com.hf.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;

/**
 * @program: springboot-07-cache
 * @description:
 * @author: xiehongfei
 * @create: 2021-03-31 21:20
 **/
@Configuration
public class MyRedisConfig {

    /**
     * 为什么要重写RedisTemplate？
     * SpringBoot官方给出了2种实例化方式，分别是RedisTemplate<Object,Object>和RedisTemplate<String,String>
     * 提供的两种方法并不好用，比方说我需要存储一个字符串指向对象的数据，如使用第一种，存储的方式则为jdk实例化，不太好懂，数据也看不清楚。如使用第二种的话，我需要手动将对象数据进行json转化，影响代码效率，存储起来也非常麻烦。
     * 3、综上，我们需要自己定义一个string，object泛型的template类来进行操作。
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<Object, Object> empRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Object> ObjectJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        template.setDefaultSerializer(employeeJackson2JsonRedisSerializer);
        //解决添加key的时候有双引号的问题
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(ObjectJackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }


    /**
     * 为什么要自定义cacheManager？
     * 1、默认创建的redisCacheManager操作redis的时候使用的是redisTempldate<Object,Object>
     * 2、redisTempldate<Object,Object>是默认使用的是jdk的序列化机制
     * 3、自定义 cacheManager
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public CacheManager myCacheManager(RedisConnectionFactory redisConnectionFactory) {
        //初始化一个RedisCacheWriter
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        //设置CacheManager的值序列化方式为json序列化
        RedisSerializer<Object> jsonSerializer = new GenericJackson2JsonRedisSerializer();
        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair
                .fromSerializer(jsonSerializer);
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(pair);
        //设置默认超过期时间是30秒
        defaultCacheConfig.entryTtl(Duration.ofSeconds(30));
        //初始化RedisCacheManager
        return new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
    }

}
