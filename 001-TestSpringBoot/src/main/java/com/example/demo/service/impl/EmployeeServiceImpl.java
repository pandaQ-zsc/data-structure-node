package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: xiong.qiang
 * @date: 2023/3/14 11:06
 */


@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Override
    public Boolean saveList(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
//            employee.setUpdateTime(new DateTime());
            employee.setUpdateTime(new Date());
            employee.setId(IdWorker.getId());
        }
        return saveBatch(employeeList);
    }
    
}
