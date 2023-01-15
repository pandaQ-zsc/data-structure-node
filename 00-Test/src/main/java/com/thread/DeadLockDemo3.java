package com.thread;

public class DeadLockDemo3 {
    private static Object res1 = new Object();
    private static Object res2 = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (res1) {
                System.out.println(Thread.currentThread() + " get res1");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get res2");
                synchronized (res2) {
                    System.out.println(Thread.currentThread() + "get res2");
                }
            }
        }, "线程1");
        Thread t2 = new Thread(() -> {
            synchronized (res2) {
                System.out.println(Thread.currentThread() + "get res2");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get res1");

                synchronized (res1) {
                    System.out.println(Thread.currentThread() + "get res1");
                }
            }
        }, "线程2");
        t1.start();
        t2.start();
    }

}
