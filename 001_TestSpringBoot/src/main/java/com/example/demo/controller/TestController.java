package com.example.demo.controller;



import com.example.demo.entity.ResponseBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xiong.qiang
 * @date: 2023/2/21 14:30
 */



@RestController
public class TestController {
    @GetMapping("/testGet")
    public String  testGet(){
        return "hahahaha   你真好";
    }

}
