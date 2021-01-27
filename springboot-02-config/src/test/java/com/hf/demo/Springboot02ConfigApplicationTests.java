package com.hf.demo;

import com.hf.demo.pojo.BootConfigurationProperties;
import com.hf.demo.pojo.Dog;
import com.hf.demo.pojo.Gcsoft;
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

	@Autowired
	private Gcsoft gcsoft;

	@Autowired
	private BootConfigurationProperties bootConfigurationProperties;

	@Test
	void contextLoads() {
		System.out.println(dog);
		System.out.println(person);
		System.out.println(gcsoft);
		System.out.println(bootConfigurationProperties);
	}

}
