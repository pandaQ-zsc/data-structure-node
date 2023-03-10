package com.example.demo.synchronizes;

import lombok.Synchronized;

/**
 * @author: xiong.qiang
 * @date: 2023/3/9 14:01
 */
public class SynchronizeDemo {

    private int count = 0;


    @Synchronized
    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            errorSync();
        }


    }


    /**
     * @throws InterruptedException
     * @Syncronize 加在需要操作的对象方法上面 increment()上面，
     */
    private static void errorSync() throws InterruptedException {
        SynchronizeDemo obj = new SynchronizeDemo();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                obj.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                obj.increment();
            }
        });
        t1.start();
        t2.start();
        /*
          t1.join()是Java中的一个方法，它可以让当前线程（通常是主线程）等待t1线程执行完毕后再继续执行。具体来说，当调用t1.join()时，当前线程将被阻塞，直到t1线程执行完毕或超时（如果指定了超时时间）。
          在多线程编程中，通常需要等待子线程完成某个任务后再进行下一步操作，此时可以使用t1.join()方法。在上面的例子中，t1.join()的作用是让主线程等待线程t1执行完毕后再继续执行后面的代码，以确保t1线程的执行结果能够被正确地输出。
          需要注意的是，如果t1线程发生了异常而被中断，那么在主线程中调用t1.join()时也会抛出相应的异常。此外，如果t1线程永远不会结束，那么主线程就会一直等待，造成死锁，因此在使用join()方法时需要慎重考虑超时等相关因素
         */
        t1.join();
        /*
           在上面的例子中，如果不加t1.join()和t2.join()，那么主线程会立即执行System.out.println(obj.getCount())语句，此时t1和t2线程仍在执行中，可能还没有对共享资源进行同步，因此输出的结果可能不是预期的2000。
           如果加上t1.join()和t2.join()，那么主线程会等待t1和t2线程执行完毕后再执行System.out.println(obj.getCount())语句，这样可以确保在输出结果时，t1和t2线程已经完成了所有递增操作并对共享资源进行了同步，输出的结果一定是2000。
           因此，加上t1.join()和t2.join()的作用是等待所有子线程执行完毕再执行后续代码，从而保证程序的正确性。如果不等待子线程执行完毕就直接输出结果，可能会导致并发问题和不确定的结果。
         */
        t2.join();
        System.out.println(obj.getCount());
    }
}
