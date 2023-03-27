package com.lee.栈_队列;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _347_前K个高频元素 {
    //给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
    //输入: nums = [1,1,1,2,2,3], k = 2
    //输出: [1,2]
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }

    public static int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue()-o2.getValue());
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.add(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[k];
        for (int i = k-1; i>=0 ; i--) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = topKFrequent2(new int[]{1, 1, 1, 2, 3, 4,4,2,2,2,3}, 3);
        for (int anInt : ints) {
            System.out.print(anInt+"_");
        }
    }
}

