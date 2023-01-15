package com.thread;

import java.util.Random;

/**
 * @author xxx
 */
public class ThreadLocalDemo2 {
    ThreadLocal<Integer> count = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        ThreadLocalDemo2 demo = new ThreadLocalDemo2();
        for (int i = 0; i < 5; i++) {
            System.out.println((int) (Math.random() * 10));
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    demo.count.set(demo.count.get() + new Random().nextInt(10));
                    System.out.println("Thread : " + Thread.currentThread().getName() + " | " + demo.count.get());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    demo.count.remove();
                }
            }, String.valueOf(i)).start();
        }
    }

}