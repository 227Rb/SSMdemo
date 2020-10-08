package cn.yygcloud.ssmdemo.services;

import cn.yygcloud.ssmdemo.domain.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    int add(Employee employee);

    int update(Employee employee);

    int del(int id);

}
