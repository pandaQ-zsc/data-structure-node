package com.threadTest;


/**
 * @author Xiong Qiang
 * @date 2024/9/19 11:17
 */
public class Data {
    private int value;        // 存储生产的数据
    private boolean flag = false;  // 标志位，指示缓冲区是否有数据

    // 生产者方法
    public synchronized void produce(int value) throws InterruptedException {
        while (flag) {
            wait();  // 如果已有数据，生产者等待
        }
        this.value = value;
        System.out.println("Produced: " + value);
        flag = true;  // 设置标志位，表示缓冲区现在有数据
        notify();     // 通知消费者可以消费
    }

    // 消费者方法
    public synchronized void consume() throws InterruptedException {
        while (!flag) {
            wait();  // 如果没有数据，消费者等待
        }
        System.out.println("Consumed: " + value);
        flag = false;  // 设置标志位，表示缓冲区现在为空
        notify();      // 通知生产者可以继续生产
    }
}
