package com.threadTest;

class DataTest {
    public static void main(String[] args) {
        Data data = new Data();

        // 创建生产者线程
        Thread producer = new Thread(() -> {
            int i = 0;
            try {
                while (true) {
                    data.produce(i++);  // 生产数据并增加
                    Thread.sleep(1000);  // 等待 1 秒钟
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 创建消费者线程
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    data.consume();  // 消费数据
                    Thread.sleep(1500);  // 等待 1.5 秒钟
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 启动线程
        producer.start();
        consumer.start();
    }
}