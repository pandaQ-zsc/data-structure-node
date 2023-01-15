package com.leecode.高频题;

//双重校验锁实现对象单例（线程安全）

public class Singleton {
    //使⽤ volatile 可以禁⽌ JVM 的指令重排，保证在多线程环境下也能正常运⾏。
    private volatile static Singleton uniqueInstance;
    private Singleton() {
    }
    public static Singleton getUniqueInstance() {
        //先判断对象是否已经实例过，没有实例化过才进⼊加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}