package com.example.demo.testDemo;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

import java.time.LocalDateTime;

/**
 * @author: xiong.qiang
 * @date: 2023/3/9 13:56
 */
public class TestDemo1 {
    public static void main(String[] args) {
        System.out.println("date --->  " + new DateTime());
        System.out.println("date --->  " + LocalDateTime.now());

        System.out.println("123123" != "123123");

        System.out.println("Synchronize 用例");
        for (int i = 0; i < 10; i++) {
            //默认生成的就是雪花算法
            System.out.println(IdWorker.getId());
        }
        System.out.println("===============");
        for (int i = 0; i < 10; i++) {
            System.out.println(new Snowflake().nextId());
        }
    }
}
