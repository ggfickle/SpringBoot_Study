package com.hf.springboot09elastic;

import org.elasticsearch.client.RestClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot09ElasticApplicationTests {

    @Autowired
    RestClient restClient;

    @Test
    void contextLoads() {
    }

}
