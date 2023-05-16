package com.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: xiong.qiang
 * @date: 2023/4/9 10:42
 */

//TOPK问题：优先队列实现    镜像题目ref : leetcode:215
//https://bbs.huaweicloud.com/blogs/357409
public class TopK {
    /**
     * 求数组中最大k个元素
     * @param arr 数据
     * @param k 最大元素个数
     * @return 小根堆
     */
    public static PriorityQueue<Integer> topKMax(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        if (k <= 0) return priorityQueue;
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                priorityQueue.offer(arr[i]);
            } else {
                if (priorityQueue.isEmpty()) return priorityQueue;
                int top = priorityQueue.peek();
                if (arr[i] > top) {
                    //1.堆顶出队
                    priorityQueue.poll();
                    //2.入队并重新调整为小根堆
                    priorityQueue.offer(arr[i]);
                }
            }
        }
        return priorityQueue;
    }

    /**
     * 求前k个最小的元素
     * @param arr 数据
     * @param k 最小的元素个数
     * @return 大根堆
     */
    public static PriorityQueue<Integer> topKMin(int[] arr, int k) {
        //建大堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        if (k <= 0) return priorityQueue;
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                priorityQueue.offer(arr[i]);
            } else {
                if (priorityQueue.isEmpty()) return priorityQueue;
                int top = priorityQueue.peek();
                if (arr[i] < top) {
                    //1.堆顶出队
                    priorityQueue.poll();
                    //2.入队并重新调整为大根堆
                    priorityQueue.offer(arr[i]);
                }
            }
        }
        return priorityQueue;
    }
    public static void main(String[] args) {
        int[] data = {3,2,4,5,6,1,7,9,8};
        PriorityQueue<Integer> ret = topKMax(data,3);//7,8,9
        System.out.print("前k个最大的元素：");
        System.out.println(ret);
        ret = topKMin(data, 3);
        System.out.print("前k个最小的元素：");
        System.out.println(ret);
    }
}