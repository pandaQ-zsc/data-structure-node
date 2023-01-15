package com.单例;

public class Singleton4 {
    private static volatile Singleton4 instance = null;

    private Singleton4() {
    }

    private static Singleton4 getInstance() {
        if (null == instance) {
            synchronized (Singleton4.class) {
                if (null == instance) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
