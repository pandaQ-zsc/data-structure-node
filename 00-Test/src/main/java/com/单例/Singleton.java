package com.单例;

public class Singleton {
    //java  -- > 字节码 --> 根据字节码执行对应的c/c++代码--> c/c++代码被编译成换边语言->和硬件电路交互
    //显示中，为了获取更好的性能JVM可能会对指令进行冲排序，多线程下可能会出现一些意想不到的问题。
    //使用volatile则会禁止指令重排序，当然这也一定程度上降低了代码执行效率

    private volatile static Singleton instance = null;

    private Singleton() {
    }


    //比较老旧
    public static Singleton getInstance() {
        if (null == instance) {
            synchronized (Singleton.class) {
                if (null == instance) {
                    instance = new Singleton();
                }
            }
        }
        //除了第一次为null，其他每次请求基本上都是不为null的。
        return instance;
    }

}
