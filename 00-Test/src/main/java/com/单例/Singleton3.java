package com.单例;

import java.io.Serializable;

//懒汉式 DCL
public class Singleton3 implements Serializable {
    private Singleton3() {
        System.out.println("private Singleton3()");
    }

    private static volatile Singleton3 INSTANCE = null;

    private static Singleton3 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton3.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton3();
                }
            }
        }
        return INSTANCE;
    }
}
