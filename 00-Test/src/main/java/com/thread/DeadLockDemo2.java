package com.thread;
//https://github.com/Snailclimb/JavaGuide/blob/master/docs/java/multi-thread/Java%E5%B9%B6%E5%8F%91%E5%9F%BA%E7%A1%80%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98%E6%80%BB%E7%BB%93.md#81-%E8%AE%A4%E8%AF%86%E7%BA%BF%E7%A8%8B%E6%AD%BB%E9%94%81
public class DeadLockDemo2 {
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + " cur --- resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "wait-- resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "cur -- resource2");
                }
            }
        }, "Tread1").start();
        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + " cur --- resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "wait-- resource1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + "cur -- resource1");
                }
            }
        }, "Tread2").start();
    }
}
