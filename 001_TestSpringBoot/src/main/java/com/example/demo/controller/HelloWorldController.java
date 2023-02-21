package com.example.demo.controller;

import lombok.Cleanup;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by XQ on 2021/11/6.
 */

@RestController
@RequestMapping("/test/demo")
public class HelloWorldController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
