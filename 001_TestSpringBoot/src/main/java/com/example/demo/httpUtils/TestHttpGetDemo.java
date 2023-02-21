package com.example.demo.httpUtils;

import com.example.demo.entity.ResponseBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * @author: xiong.qiang
 * @date: 2023/2/21 15:40
 */


@Service
public class TestHttpGetDemo {
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test01() throws Exception {
        String url = "http://localhost:8080/testGet";
        if (Optional.ofNullable(restTemplate).isPresent()){
        ResponseEntity<ResponseBean> responseEntity = restTemplate.getForEntity(url, ResponseBean.class);
        System.out.println(responseEntity);
        }else {
            throw  new Exception("restTemplate 未注入");
        }
    }

}
