package com.lee.排序_数组;

public class _27_移除元素 {
    // 1 2 2 3 4
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
