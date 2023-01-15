package com.leecode.排序_数组;

import java.util.Arrays;

public class _977_有序数组的平方 {
    //输入：nums = [-4,-1,0,3,10]
    //输出：[0,1,9,16,100]
    //解释：平方后，数组变为 [16,1,0,9,100]
    //排序后，数组变为 [0,1,9,16,100]
    //
    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int [] result = new int[nums.length];
        int index = nums.length-1;
        while(left <= right){
            if (nums[left] * nums[left] > nums[right] * nums[right]){
                result[index--] = nums[left] * nums[left];
                left ++;
            }else{
                result[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = sortedSquares(new int[]{-4, -1, 0, 3, 10});
        for( int i : ints){
            System.out.println(i);
        }
    }
}
