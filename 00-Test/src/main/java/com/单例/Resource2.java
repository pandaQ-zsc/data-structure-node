package com.单例;

public class Resource2 {
    //https://www.runoob.com/java/java-enum.html
    //https://blog.csdn.net/fly910905/article/details/79286680

    private Resource2() {
    }

    private enum Singleton {
        INSTANCE;
        private Resource2 instance = null;

        Singleton() {
            instance = new Resource2();
        }

        private Resource2 getInstance() {
            return instance;
        }
    }

    public static Resource2 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }
}
