package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Employee;

import java.util.List;

/**
 * @author: xiong.qiang
 * @date: 2023/3/14 11:05
 */
public interface EmployeeService extends IService<Employee> {
    Boolean saveList(List<Employee> employeeList);
}
