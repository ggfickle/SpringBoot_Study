package com.hf.mapper;

import com.hf.pojo.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @program: springboot-07-cache
 * @description:
 * @author: xiehongfei
 * @create: 2021-03-23 20:22
 **/
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where department_id=#{departmentId}")
    public Department getDepartmentById(Integer departmentId);

    @Insert("insert into department values(#{default}, #{departmentName})")
    public void insertDept(Department department);
}
