package com.hf.repository;

import com.hf.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: springboot-06-data-jpa2
 * @description: repository
 * @author: xiehongfei
 * @create: 2021-03-19 21:07
 **/
public interface UserRepository extends JpaRepository<User,Integer> {
}
