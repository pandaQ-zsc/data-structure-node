package com.leecode.递归_dp;

public class _300_最长递增子序列 {
    //输入：nums = [10,9,2,5,3,7,101,18]
    //输出：4
    //解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int [] dp = new int[nums.length];
        //状态初始值
        int max = dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            dp[i] =1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    //状态转移
                    dp[i] = Math.max(dp[i] ,dp[j] + 1);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
