package com.leecode.高频题;

public class _300_最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int dp[] = new int[nums.length];
        int max = dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;

    }
}
