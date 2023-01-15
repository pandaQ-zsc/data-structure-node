package com.thread;

public class ThreadTest05 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (ThreadTest05.class) {
                System.out.println("t1 抢占到锁资源");
            }
        });
        synchronized (ThreadTest05.class) {
            t1.start();
            
            System.out.println("t1 的状态 ： " + t1.getState());
        }
    }
}
