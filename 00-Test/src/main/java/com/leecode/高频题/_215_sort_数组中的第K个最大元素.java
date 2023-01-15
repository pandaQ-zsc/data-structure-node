package com.leecode.高频题;

import java.util.Arrays;

public class _215_sort_数组中的第K个最大元素 {
    //给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
    //请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第k个不同的元素。
    //输入: [3,2,1,5,6,4] 和 k = 2
    //输出: 5
    //输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
    //输出: 4
    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        int res = nums[0];
//        if (k > nums.length) return 0;
//        for (int i = nums.length-1; i >0 ; i--,k--) {
//            if (k==1){
//                res = nums[i];
//            }
//        }
//        return res;
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k];
    }

}
