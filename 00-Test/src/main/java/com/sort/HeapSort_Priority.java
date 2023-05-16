package com.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: xiong.qiang
 * @date: 2023/4/11 10:20
 */
public class HeapSort_Priority {
    public static void heapSort(int[] arr) {
        // 创建一个优先队列，使用默认的比较器来实现小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);

        // 将数组中的所有元素添加到优先队列中
        for (int num : arr) {
            pq.offer(num);
        }

        // 依次取出优先队列中的元素，将其放回数组中
        for (int i = 0; i < arr.length; i++) {
            if (pq.peek() !=null){
            arr[i] = pq.poll();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 9, 7};
        heapSort(arr);
        //数组展示
        System.out.println(Arrays.toString(arr));
    }
}
