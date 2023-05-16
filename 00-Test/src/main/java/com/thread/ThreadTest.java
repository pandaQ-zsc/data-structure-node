package com.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
;

public class ThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 线程开启方式
         * 1.继承Thread
         * 2.实现Runnable接口
         * 3.实现Callable接口 + FutureTask (可以拿到返回结果，可以处理异常)
         * 4.线程池  (从线程池中直接开启)   -- 最常用  。 因为每次任务一过来就启动一个线程的话  开销太大了
         *
         * 区别；
         *      1、2不能得到返回值，3可以获取返回值
         *      1、2、3都不能控制资源
         *      4可以控制资源 性能稳定。
         */

        //一般业务代码里面使用线程池的方式【将所有的多线程异步任务都交给线程池执行】
        //使用线程池创建异步对象
//        ExecutorService service = Executors.newFixedThreadPool(10);
//        CompletableFuture.runAsync(()->{
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//        },service);

        //启动异步任务。
//        ExecutorService executor = Executors.newFixedThreadPool(10);
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            int i = 20 / 2;
//            return i;
//        }, executor).whenComplete().handle();
//        CompletableFuture.supplyAsync(()->{
//
//        },executor).thenRun().whenComplete().handle().thenApplyAsync(,executor);
//        方式一
        System.out.println("main .... start");
        Thread01 thread01 = new Thread01();
        thread01.start();
//        thread01.wait();
        System.out.println("main ... end ");


//        //方式二
        System.out.println("main .... start");
        Runnable01 runnable01 = new Runnable01();
        new Thread(runnable01).start();
        new Thread(new Thread01()).start();
        System.out.println("main ... end ");

        //方式三
        System.out.println("main .... start");
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable01());
        new Thread(futureTask).start();
        //阻塞等待整个线程执行完成，获取返回结果
        Integer i  = futureTask.get();
        System.out.println("main ... end " + i );

    }
    public static class Thread01 extends Thread{
        @Override
        public void run() {
            System.out.println("当前线程： "+ Thread.currentThread().getId());
            int i = 10 /2 ;
            System.out.println( "运行结果：" + i );
        }
    }
    public static class Runnable01 implements Runnable{
        @Override
        public void run() {
            System.out.println("implements - Runnable -当前线程： "+ Thread.currentThread().getId());
            int i = 10 /2 ;
            System.out.println( "implements - Runnable -运行结果：" + i );
        }
    }
    public static class Callable01 implements Callable{

        @Override
        public Object call() throws Exception {
            System.out.println("当前线程： "+ Thread.currentThread().getId());
            int i = 10 /2 ;
            System.out.println( "运行结果：" + i );
            return  i ;
        }
    }
    //死锁代码
//    public static class diedLock {
//        public static void main(String[] args) {
//            new Thread(()->{
//                synchronized (resource1){
//                    try {
//                        Thread.sleep(1000);
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread() + "waiting get 2 ");
//                    synchronized (resource2){
//                        System.out.println("....");
//                    }
//                }
//            }).start();
//            new Thread(()->{
//                synchronized (resource2){
//                    try {
//                        Thread.sleep(1000);
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread() + "waiting get 1 ");
//                    synchronized (resource1){
//                        System.out.println("....");
//                    }
//                }
//            }).start();
//        }
//    }
}
