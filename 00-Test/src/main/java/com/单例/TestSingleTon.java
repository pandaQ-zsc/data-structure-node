package com.单例;

public class TestSingleTon {
    public static void main(String[] args) {
        Singleton1.otherMethod();
        System.out.println("在otherMethod()执行之前已经初始化 Singleton1()");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(Singleton1.getInstance());
        System.out.println(Singleton1.getInstance());
    }
}
