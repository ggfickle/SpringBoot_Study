package com.hf.mapper;

import com.hf.pojo.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @program: springboot-07-cache
 * @description:
 * @author: xiehongfei
 * @create: 2021-03-23 20:10
 **/
@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where employee_id=#{employeeId}")
    public Employee getEmployeeById(Integer employeeId);

    @Update("update employee set employee_name=#{employeeName},employee_email=#{employeeEmail},employee_gender=#{employeeGender},d_id=#{dId} where employee_id=#{employeeId}")
    public void updateEmployee(Employee employee);

    @Delete("delete from employee where employeeId=#{id}")
    public void deleteEmp(Integer id);

    @Insert("insert into employee values(default,#{employeeName},#{employeeEmail},#{employeeGender},#{dId})")
    public void insertEmp(Employee employee);
}
