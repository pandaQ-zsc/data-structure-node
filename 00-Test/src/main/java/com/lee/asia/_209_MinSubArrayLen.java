package com.lee.asia;

import sun.text.resources.cldr.ii.FormatData_ii;

import java.time.OffsetDateTime;

/**
 * @author: xiong.qiang
 * @date: 2023/3/22 16:31
 */

//给定一个含有n个正整数的数组和一个正整数 target 。
//
//找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
//
//示例 1：
//
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组[4,3]是该条件下的长度最小的子数组。

//示例 2：
//
//输入：target = 4, nums = [1,4,4]
//输出：1
//
public class _209_MinSubArrayLen {

    //暴力: ok
    public static int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum > target) return 1;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    min = Math.min(min, j - i - 1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    //ok
    public static int minSubArrayLenTest(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum > target){
                return  1;
            }
            for (int j = i+1; j <nums.length ; j++) {
                sum += nums[j];
                if (sum >= target){
                    min = Math.min(min,j-i-1);
                    break;
                }
            }
        }
        return  min  == Integer.MAX_VALUE ? 0:min;
    }




    // Double  while achievement
    // Sliding Window : ok
    public static int minSubArrayLen2(int target, int[] nums) {
        int l = 0, r = 0, sum = 0;
        int min = Integer.MAX_VALUE;
        while (r <= nums.length - 1) {
            sum += nums[r++];
            while (sum >= target) {
                sum -= nums[l++]; //这里体现出滑动窗口的精髓：  不断变更i (子序列的起始位置)
                min = Math.min(min, r-l+1); //取出最小子序列长度
                if (min == 1) return 1;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    // For 循环实现 circulation achievement
    // Sliding Window : ok

    public static int minSubArrayLen1(int target, int[] nums) {
        int l =0, sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >=target){
                min = Math.min(min,i-l+1);
                sum -= nums[l++];
                if (min == 1) return 1;
            }

        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    public static int minSubArrayLen3(int target, int[] nums) {
       int l= 0 ,sum = 0;
       int min  = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >=  target){
                min = Math.min( i-l+1,min);
                sum -= nums[l++];
                if (min == 1) return 1;
            }
        }
        return  min == Integer.MAX_VALUE ? 0 : min;
    }


//示例 1：
//
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组[4,3]是该条件下的长度最小的子数组。

    //示例 2：
//
//输入：target = 4, nums = [1,4,4]
//输出：1
//
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
//        int[] nums = new int[]{1, 2, 3, 4, 5};
        int res = minSubArrayLen3(7, nums);
        System.out.println(res);
    }

}
