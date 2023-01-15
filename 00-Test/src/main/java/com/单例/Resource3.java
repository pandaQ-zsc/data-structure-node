package com.单例;

public class Resource3 {
    private static Resource3 resource;

    private Resource3() {

    }

    enum Singleton {
        INSTANCE;

        Singleton() {
            resource = new Resource3();
        }

        private static Resource3 getInstance() {
            return resource;
        }
    }

    public static Resource3 getInstance() {
        return Resource3.Singleton.getInstance();
    }

    public static void main(String[] args) {
        Resource3 instance1 = Resource3.getInstance();
        Resource3 instance2 = Resource3.getInstance();
        System.out.println("instance1==instance2 -->" + (instance1 == instance2));

    }
}
