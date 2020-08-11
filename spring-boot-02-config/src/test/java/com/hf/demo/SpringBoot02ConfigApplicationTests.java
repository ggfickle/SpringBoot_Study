package com.hf.demo;

import com.hf.demo.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.security.RunAs;
import javax.xml.transform.Source;

@SpringBootTest
class SpringBoot02ConfigApplicationTests {

	@Autowired
	Person person;

	@Test
	void contextLoads() {
		System.out.println(person);
	}

}
