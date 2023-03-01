package com.example.demo.controller;


import com.example.demo.entity.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xiong.qiang
 * @date: 2023/2/21 14:30
 */


@RestController
public class TestController {

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/testGet")
    public ResponseBean testGet(@RequestParam String userCode, @RequestParam String userMsg) {
        ResponseBean res = new ResponseBean(userCode, userMsg);
        System.out.println("-----------hahahahahah-----------");
        return res;
    }

    @GetMapping("/testGet1")
    public String testGet1() {
        return "hahaha";
    }

    @PostMapping("/testPostHeader")
    public ResponseBean testPost(@RequestParam("userCode") String userCode, @RequestParam("userMsg") String userMsg) {
        return new ResponseBean(userCode, userMsg);
    }
}
