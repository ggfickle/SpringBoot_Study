package com.hf.demo;

import com.hf.demo.pojo.Dog;
import com.hf.demo.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02ConfigApplicationTests {

	@Autowired
	private Dog dog;

	@Autowired
	private Person person;

	@Test
	void contextLoads() {
		System.out.println(dog);
		System.out.println(person);
	}

}
