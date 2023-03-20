package com.example.demo.thread;

/**
 * @author: xiong.qiang
 * @date: 2023/3/16 17:31
 * Reference Website : https://www.cnblogs.com/skywang12345/p/3479202.html
 */
public class MyThread2 implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    count++;
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread2 myThread2 = new MyThread2();
        Thread t1 = new Thread(myThread2, "t1");
        Thread t2 = new Thread(myThread2, "t2");
        t1.start();
        t2.start();
        // join用来保证  t1. t2线程执行完后置行 sout操作
        t1.join();
        t2.join();
        System.out.println(myThread2.count);
    }
}
