package com.hf.service.impl;

import com.hf.mapper.EmployeeMapper;
import com.hf.pojo.Employee;
import com.hf.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @program: springboot-07-cache
 * @description:
 * @author: xiehongfei
 * @create: 2021-03-23 20:55
 **/
@CacheConfig(cacheNames = "emp",cacheManager ="myCacheManager") //抽取缓存的公共配置
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * Cacheable 将方法的结果进行缓存；以后再要相同的数据直接从缓存中获取，不用调用方法
     * cacheManage管理多个cache组件的，对缓存真正的crud操作在cache组件中，每一个缓存组件有一个自己唯一的名字
     * 几个属性：
     * cacheNames/value ：指定缓存组件的名字
     * key:缓存数据的key：可以用它来指定，默认使用参数的值  key = "#employeeId"  可以编写spel表达式进行取值拼接
     * #employeeId;参数employeeId的值，等同于#a0  #p0   #root.args[0]
     * keyGenerator:key的生成器；可以自己指定key的生成器的组件id
     * key/keyGenerator ：二选一使用
     * cacheManager：指定缓存管理器，或者cacheResolver指定获取解析器
     * condition：指定符合条件的情况下才缓存
     * unless：否定缓存   ；当unless指定的条件为true，方法的返回值就不会被缓存，与condition相反；可以获取到结果进行判断  unless = "#result==null"
     * sync:是否使用异步模式
     *
     * @param employeeId
     * @return
     */
    //    @Cacheable(value = "emp", keyGenerator = "myKeyGenerator", condition = "#employeeId>0 and #root.methodName eq 'aaa'")
//    @Cacheable(cacheNames = "emp", key = "#root.methodName+'['+#employeeId+']'")
    @Cacheable(/*value = "emp",*/ key = "#employeeId")
    @Override
    public Employee getEmployeeById(Integer employeeId) {
        System.out.println("查询了" + employeeId + "号员工");
        Employee employee = employeeMapper.getEmployeeById(employeeId);
        return employee;
    }

    /**
     * @param employee
     * @return
     * @CachePut即调用方法，又更新缓存数据 修改了数据库的某个数据，同时又更新缓存
     * 运行时机：
     * 1、先调用方法
     * 2、将目标方法的结果缓存起来
     * <p>
     * 注：记得要与查询缓存的key保持一致，，否则导致更新后查询还是原来的结果
     */
    @CachePut(/*value = "emp",*/ key = "#employee.employeeId")
    @Override
    public Employee updateEmployee(Employee employee) {
        System.out.println("updateEmp:" + employee.getEmployeeId());
        employeeMapper.updateEmployee(employee);
        return employee;
    }

    /**
     * @param id
     * @return
     * @CacheEvict缓存清除 key：指定要清除的数据的key
     * allEntries = true:指定清除缓存中所有的数据
     * beforeInvocation = false:缓存的清除是否在方法执行之前,默认是在方法执行之后执行，如果出现异常的话缓存就不会清除
     * beforeInvocation = true：代表清除缓存操作是在方法执行之前，无论方法是否出现异常，缓存都会清除
     */
    @CacheEvict(/*value = "emp",*/ key = "#id")
    @Override
    public Integer deleteEmp(Integer id) {
        System.out.println("deleteEmp..");
        return employeeMapper.deleteEmp(id);
    }

    @Override
    public Integer insertEmp(Employee employee) {
        return employeeMapper.insertEmp(employee);
    }

    /**
     * @CachePut注解下的方法体一定会执行的
     * @param empName
     * @return
     */
    @Caching(
            cacheable = {
                    @Cacheable(/*value = "emp",*/ key = "#empName")
            },
            put = {
                    @CachePut(/*value = "emp",*/ key = "#result.employeeId"),
                    @CachePut(/*value = "emp",*/ key = "#result.employeeEmail")
            }
    )
    @Override
    public Employee getEmpByName(String empName) {
        System.out.println("getEmpByName:" + empName);
        return employeeMapper.getEmpByName(empName);
    }
}
