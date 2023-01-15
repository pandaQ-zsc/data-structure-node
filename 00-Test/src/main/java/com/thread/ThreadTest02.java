package com.thread;

/**
 * Created by XQ
 * 2022/6/5
 */
public class ThreadTest02 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            //解决线程同步安全问题
            // 使用synchronized(同步监视器)
            // {
            //     包裹业务代码  }
            show();

        }
    }

    private synchronized void show() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票，当前票号为:" + ticket);
            ticket--;
        }
    }


    public static void main(String[] args) {
        ThreadTest02 threadTest01 = new ThreadTest02();
        Thread t1 = new Thread(threadTest01);
        Thread t2 = new Thread(threadTest01);
        Thread t3 = new Thread(threadTest01);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();

    }

}
