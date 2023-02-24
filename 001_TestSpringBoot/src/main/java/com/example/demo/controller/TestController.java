package com.example.demo.controller;



import com.example.demo.entity.ResponseBean;
import org.springframework.web.bind.annotation.*;

/**
 * @author: xiong.qiang
 * @date: 2023/2/21 14:30
 */



@RestController
public class TestController {
    @GetMapping("/testGet")
    public ResponseBean  testGet(@RequestParam String userCode ,@RequestParam String userMsg){
        ResponseBean res = new ResponseBean(userCode, userMsg);
        System.out.println("-----------hahahahahah-----------");
        return res;
    }

    @PostMapping("/testPostHeader")
    public ResponseBean testPost(@RequestParam("userCode") String userCode, @RequestParam("userMsg") String userMsg){
        return new ResponseBean(userCode,userMsg);
    }
}
