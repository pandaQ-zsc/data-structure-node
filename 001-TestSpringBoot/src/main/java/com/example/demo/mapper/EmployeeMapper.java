package com.example.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: xiong.qiang
 * @date: 2023/3/14 11:10
 */


@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {


    //    @Select("SELECT * from `employees` where name = '刘强东'")
    @Select("SELECT * from `employees`")
    List<Employee> getEmployeeList();
}
