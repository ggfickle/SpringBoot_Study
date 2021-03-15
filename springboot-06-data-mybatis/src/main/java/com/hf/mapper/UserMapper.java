package com.hf.mapper;

import com.hf.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program: springboot-06-data-mybatis
 * @description: user mapper
 * @author: xiehongfei
 * @create: 2021-03-15 20:44
 **/

@Mapper
public interface UserMapper {

    @Select("select * from user")
    public List<User> selectAllUser();

    @Select("select * from user where id=#{id}")
    public User selectUserById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into user(username,password) values(#{userName},#{password})")
    public Integer insertUser(User user);

    @Delete("delete from user where username=#{userName}")
    public Integer deleteUserByUserName(User user);

    @Update("update user set name=#{userName} and password=#{password} where username=#{userName}")
    public Integer updateUserByUserName(User user);
}
