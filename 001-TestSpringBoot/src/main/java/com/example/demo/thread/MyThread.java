package com.example.demo.thread;

/**
 * @author: xiong.qiang
 * @date: 2023/3/16 16:46
 */
public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is Running");
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread("hahahaha");
        System.out.println(Thread.currentThread().getName() + "  call MyThread Start");
        t1.start();
        System.out.println(Thread.currentThread().getName() + "  call MyThread Run");
        t1.run();
    }
}

