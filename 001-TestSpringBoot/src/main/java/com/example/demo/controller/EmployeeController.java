package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.entity.R;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiong.qiang
 * @date: 2023/3/14 10:38
 */

@RestController
@Slf4j
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @Autowired
    EmployeeMapper employeeMapper;

    @RequestMapping("/getAll")
    public R getAll() {
//        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> employeeList = employeeMapper.getEmployeeList();
        return R.ok(employeeList);
    }

    @PostMapping("/save")
    public R saveAll() {
        List<Employee> list = new ArrayList<>();

        list.add(new Employee("马化腾", 34, 6000.38));
        list.add(new Employee("马云", 12, 9876.12));
//        list.add(new Employee(1003, "刘强东", 33, 3000.82));
        list.add(new Employee("刘强东", 53, 6000.82));
        list.add(new Employee("雷军", 26, 7657.37));
//        list.add(new Employee(1004, "雷军", 36, 9657.37));
        list.add(new Employee("李彦宏", 65, 5555.32));
        list.add(new Employee("比尔盖茨", 42, 9500.43));
        list.add(new Employee("任正非", 26, 4333.32));
        list.add(new Employee("扎克伯格", 35, 2500.32));
        return R.ok(employeeService.saveList(list));
    }

}

