package com.hf;

import com.hf.mapper.DepartmentMapper;
import com.hf.pojo.Department;
import com.hf.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class Springboot07CacheApplicationTests {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisTemplate<Object, Object> empRedisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testRedis() {
        //测试保存字符串
//        stringRedisTemplate.opsForValue().set("name","zhangsan");

        //测试保存对象
        Department department = departmentMapper.getDepartmentById(1);
        //默认情况下，如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
//        redisTemplate.opsForValue().set("dep-01",department);

        //1、将数据以json的形式保存
        //1）例如jackjson、fastjson
        //2)使用自己的配置
        String depName = "dep-03";
        empRedisTemplate.opsForValue().set(depName, department);
        System.out.println("dep:" + empRedisTemplate.opsForValue().get(depName));
    }

    @Test
    void contextLoads() {
        Department department = departmentMapper.getDepartmentById(1);
        System.out.println(department);
    }

}
