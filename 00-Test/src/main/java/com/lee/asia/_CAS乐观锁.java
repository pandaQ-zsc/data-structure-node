package com.lee.asia;

import java.util.concurrent.atomic.AtomicInteger;

public class _CAS乐观锁 {


    private static AtomicInteger count = new AtomicInteger(0);

    /**
     * 乐观锁
     */
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //每个线程让count自增100次
                    for (int i = 0; i < 100; i++) {
                        count.incrementAndGet();
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }


    /**
     * synchronized 悲观锁
     */
//    private static int count = 0;
//    public static void main(String[] args) {
//        for (int i = 0; i < 2; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try{
//                        Thread.sleep(10);
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                    //每个线程让count自增100次
//                    for (int j = 0; j < 100; j++) {
////                        count++;
//                        //synchronized同步锁
////                        synchronized (this.getClass()){
//                        synchronized (_CAS乐观锁.class){
//                            count ++ ;
//                        }
//                    }
//                }
//            }).start();
//        }
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(count);
//    }

}
