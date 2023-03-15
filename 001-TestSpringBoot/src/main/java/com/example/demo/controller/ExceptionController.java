package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.entity.R;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xiong.qiang
 * @date: 2023/3/15 10:15
 */


@RestController
public class ExceptionController {
    @GetMapping("/testException/{id}")
    public Employee getUser(@PathVariable("id") Long id) {
        if (id == 1) {
            return new Employee(1L, "Alice");
        } else if (id == 2) {
            throw new IllegalArgumentException("Invalid user id: " + id);
        } else {
            throw new RuntimeException("Failed to get user with id: " + id);
        }
    }

    @GetMapping("/testException2/{id}")
    public ResponseEntity<Employee> getUser2(@PathVariable("id") Long id) {
        if (id == 1) {
            return new ResponseEntity<>(new Employee(1L, "Alice"), HttpStatus.CREATED);
        } else if (id == 2) {
            throw new IllegalArgumentException("Invalid user id: " + id);
        } else {
            throw new RuntimeException("Failed to get user with id: " + id);
        }
    }

    @GetMapping("/testException3/{id}")
    public R getUser3(@PathVariable("id") Long id) {
        if (id == 1) {
            return R.ok().setData(new Employee(1L, "Alice"));
        } else if (id == 2) {
            throw new IllegalArgumentException("Invalid user id: " + id);
        } else {
            throw new RuntimeException("Failed to get user with id: " + id);
        }
    }
}
