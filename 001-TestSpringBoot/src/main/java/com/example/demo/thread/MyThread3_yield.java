package com.example.demo.thread;

/**
 * @author: xiong.qiang
 * @date: 2023/3/20 09:55
 */
public class MyThread3_yield extends Thread {
    private static final Object obj = new Object();

    public static void main(String[] args) {
        Thread t1 = new ThreadA("t1");
        Thread t2 = new ThreadA("t2");
        t1.start();
        t2.start();
    }

    public static class ThreadA extends Thread {
        @Override
        public void run() {
            synchronized (obj) {
                for (int i = 0; i < 10; i++) {
                    System.out.println(this.getName() + "  : " + i);
                    if (i % 4 == 0) {
                        Thread.yield();
                    }
                }
            }

        }

        public ThreadA(String name) {
            super(name);
        }
    }

}



