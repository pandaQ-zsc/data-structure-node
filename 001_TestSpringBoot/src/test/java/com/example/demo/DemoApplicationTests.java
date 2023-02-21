package com.example.demo;

import com.example.demo.entity.ResponseBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    RestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void cul() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
// 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        String s = squaresList.toString();
        System.out.println(s);
    }

    @Test
    public void test01() throws Exception {
        String url = "http://localhost:8080/testGet";
        if (Optional.ofNullable(restTemplate).isPresent()) {
            ResponseEntity<String> res = restTemplate.getForEntity(url, String.class);
            System.out.println(res);
        } else {
            throw new Exception("restTemplate 未注入");
        }
    }
}
