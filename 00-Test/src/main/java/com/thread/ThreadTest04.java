package com.thread;

/**
 * Created by XQ
 * 2022/6/5
 */
public class ThreadTest04 extends Thread {

    private static int ticket = 100;

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

    private static synchronized void show() {
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
        ThreadTest04 t1 = new ThreadTest04();
        ThreadTest04 t2 = new ThreadTest04();
        ThreadTest04 t3 = new ThreadTest04();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();

    }

}
