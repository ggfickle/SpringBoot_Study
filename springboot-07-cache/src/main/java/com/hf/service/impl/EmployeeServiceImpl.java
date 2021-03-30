package com.hf.service.impl;

import com.hf.mapper.EmployeeMapper;
import com.hf.pojo.Employee;
import com.hf.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @program: springboot-07-cache
 * @description:
 * @author: xiehongfei
 * @create: 2021-03-23 20:55
 **/
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    private Logger logger = LoggerFactory.getLogger(getClass());

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
//    @Cacheable(cacheNames = "emp", key = "#root.methodName+'['+#employeeId+']'")
    @Cacheable(value = "emp", keyGenerator = "myKeyGenerator",condition = "#employeeId>0 and #root.methodName eq 'aaa'")
    @Override
    public Employee getEmployeeById(Integer employeeId) {
        logger.trace("------------------------getEmployeeById--------------------------");
        System.out.println("查询了" + employeeId + "号员工");
        Employee employee = employeeMapper.getEmployeeById(employeeId);
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        logger.trace("updateEmployee..");
        employeeMapper.updateEmployee(employee);
    }

    @Override
    public void deleteEmp(Integer id) {
        logger.trace("deleteEmp..");
        employeeMapper.deleteEmp(id);
    }

    @Override
    public void insertEmp(Employee employee) {
        logger.trace("insertEmp..");
        employeeMapper.insertEmp(employee);
    }
}
