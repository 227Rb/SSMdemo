package cn.yygcloud.ssmdemo.services.impl;

import cn.yygcloud.ssmdemo.dao.EmployeeDao;
import cn.yygcloud.ssmdemo.domain.Employee;
import cn.yygcloud.ssmdemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: EmployeeServiceImpl
 * @Description:
 * @author: Nan
 * @date: 2020/9/26 1:28
 * @version: V1.0
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;


    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public int add(Employee employee) {
        return employeeDao.add(employee);
    }

    @Override
    public int update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public int del(int id) {
        return employeeDao.del(id);
    }


}
