package com.lee.栈_队列;

import java.util.Arrays;
import java.util.Stack;

public class _503_下一个更大元素2 {
    // [1, 2, 1]
    // [1, 2, 1, 1, 2, 1]
    // [2, -1, 2]
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len * 2; i++) {
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                int pre = stack.pop();
                res[pre % len] = nums[i % len];
            }
            stack.push(i);
        }
        return res;

    }
}
