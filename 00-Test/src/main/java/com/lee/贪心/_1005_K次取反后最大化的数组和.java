package com.lee.贪心;

import java.util.PriorityQueue;

//输入：A = [4,2,3], K = 1
//输出：5
//解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。

//解题思路
//思路就是堆加贪心算法
//首先用堆(Java中使用优先队列实现)可以很快的获得整个数据中最小的那一个，
// 然后只需要每次将最小的取负，然后记录最原始的和记为sum，每一次更新sum，最后返回sum即可
//
public class _1005_K次取反后最大化的数组和 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums){
            queue.add(num);
            sum += num;
        }
        for (int i = 0; i < k; i++) {
            Integer poll = queue.poll();
            sum -= poll*2;
            queue.offer( -poll);
        }
        return sum;
    }
}
