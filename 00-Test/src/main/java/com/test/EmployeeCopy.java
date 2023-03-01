package com.test;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xiong.qiang
 * @date 2022/12/19 09:56
 */

@Data
@AllArgsConstructor
public class EmployeeCopy {

    public int score;
    @JSONField(name = "ID")
    @Nullable
    private int id;
    @JSONField(name = "NAME")
    private String name;

    private Integer code;

    private Date date;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeCopy() {
        System.out.println("Employee().....");
    }

    public EmployeeCopy(int id) {
        this.id = id;
        System.out.println("Employee(int id).....");
    }

    public EmployeeCopy(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private static int i = 1;

    public static void main(String[] args) {
        List<Employee> employees = EmployeeData.getEmployees();
        Map<String, List<EmployeeCopy>> collect = employees.stream().map(item -> {
            EmployeeCopy employeeCopy = new EmployeeCopy();
            BeanUtils.copyProperties(item, employeeCopy);
            employeeCopy.setCode(i++);
            return employeeCopy;
        }).collect(Collectors.groupingBy(EmployeeCopy::getName));
        collect.forEach((a, b) -> System.out.println(a + " : " + b));
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Date from = Date.from(now.toInstant(ZoneOffset.ofHours(8)));
        Date from1 = Date.from(now.toInstant(ZoneOffset.UTC));
        System.out.println(now);
        System.out.println(from);
        System.out.println(from1);
    }


}
