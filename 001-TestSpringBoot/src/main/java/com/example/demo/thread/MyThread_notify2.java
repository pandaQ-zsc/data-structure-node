package com.example.demo.thread;

/**
 * @author: xiong.qiang
 * @date: 2023/3/16 20:14
 */
public class MyThread_notify2 {

    public static void main(String[] args) {
        ThreadA t1 = new ThreadA("t1");
        //启动线程
        synchronized (t1) {
            try {
                System.out.println(Thread.currentThread().getName() + " start t1");
                t1.start();
                System.out.println(Thread.currentThread().getName() + " wait t1");
                t1.wait(3000);
                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadA extends Thread {

        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (this) {
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " call notify");
                }
            }
        }
    }


}

