package com.thread;

/**
 * Created by XQ
 * 2022/6/5
 */
public class ThreadTest03 extends Thread {

    private static int ticket = 100;

    /**
     * 加锁：任何想进入临界区的线程，必须先执行加锁操作。
     * 【若加锁（获取资源）操作顺利通过，则线程可以进入临界区】
     * 在完成对临街资源的访问后再 执行解锁操作，以释放该临界资源。

     */

    @Override
    public void run() {
        while (true) {
            //解决线程同步安全问题
            // 使用synchronized(同步监视器)
            // {
            //     包裹业务代码  }
//            synchronized (this) {// 这样的话 无法锁住 ， 因为下面 有3个  new ThreadTest03();
            synchronized (ThreadTest03.class) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，当前票号为:" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }

        }
    }

    public static void main(String[] args) {
        ThreadTest03 t1 = new ThreadTest03();
        ThreadTest03 t2 = new ThreadTest03();
        ThreadTest03 t3 = new ThreadTest03();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();

    }

}
