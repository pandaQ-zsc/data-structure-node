package com.lee.栈_队列;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

//队列
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3 n=8
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
/**
 * 用一个单调队列来存储对应的下标，每当窗口滑动的时候，直接取队列的头部指针对应的值放入结果集即可
 * 单调队列类似 （tail -->） 3 --> 2 --> 1 --> 0 (--> head) (右边为头结点，元素存的是下标)
 */
public class _239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int [] res = new int[n-k+1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            //要在窗口范围为【i-k+1,i】 中查找最大值
            //First在左端 ，  Last在右端
            // peek默认是peekFirst    poll()默认也是poll First
            while (!deque.isEmpty() && deque.peek() < i-k+1){
                deque.poll();
            }
            //维持单调最大栈
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if ( !deque.isEmpty() && i >= k-1){
                res[index++] = nums[deque.peek()];
            }
        }
        return res;
    }

    public int[] maxSlidingWindow_deque(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        if (nums.length == 1) return nums;
        //结果数组的大小
        int m = nums.length - k + 1;
        int[] maxes = new int[m];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //单调队列里面存放最大值
            while (!deque.isEmpty() && deque.peekLast() <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            int w = i - k + 1;
            if (w < 0) continue;
            if (deque.peekFirst() < w) {
                deque.pollFirst();
            }
            maxes[w] = nums[deque.peekFirst()];
        }
        return maxes;
    }


}
