package com.lee.asia;

//映射  腾讯笔试题 ：求最大子序列数组
// https://blog.csdn.net/qq_41479464/article/details/88382513
public class _53_最大子序和 {
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum >= 0) {
                sum = sum + num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;

    }

    public static int maxSubArray2(int[] nums) {
        int res = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static void main(String[] args) {
    }


}
