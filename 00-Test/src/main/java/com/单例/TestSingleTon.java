package com.单例;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestSingleTon {
    public static void main(String[] args) {
        Singleton1.otherMethod();
        System.out.println("在otherMethod()执行之前已经初始化 Singleton1()");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(Singleton1.getInstance());
        System.out.println(Singleton1.getInstance());
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now:" + now);
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("date:" + date);
    }
}
