package com.lee.递归_dp;

public class _746_使用最小花费爬楼梯 {
    //输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
    //输出：6
    //解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
    //
    //dp[i]表示到达下标i的最小花费；
    //------
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[cost.length+1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }
}
