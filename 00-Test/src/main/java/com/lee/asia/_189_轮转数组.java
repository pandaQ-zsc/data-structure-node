package com.lee.asia;


import java.util.Arrays;

/**
 * @author Xiong Qiang
 * @date 2024/9/21 14:12
 */


public class _189_轮转数组 {
  public static void rotate(int[] nums, int k) {
    int[] newArr = new int[nums.length];
    for(int i = nums.length-1; i >= 0 ; i--){
      newArr[(i+k)%nums.length] = nums[i];
    }
    System.out.println(Arrays.toString(newArr));
    for (int i = 0; i < nums.length; i++) {
      nums[i]  = newArr[i];
    }
    System.out.println(Arrays.toString(nums));
  }
//给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。

  //输入: nums = [1,2,3,4,5,6,7], k = 3
  //输出: [5,6,7,1,2,3,4]
  //解释:
  //向右轮转 1 步: [7,1,2,3,4,5,6]
  //向右轮转 2 步: [6,7,1,2,3,4,5]
  //向右轮转 3 步: [5,6,7,1,2,3,4]

  public static void main(String[] args) {
    rotate(new int[]{1,2,3,4,5,6,7},3);



  }
}
