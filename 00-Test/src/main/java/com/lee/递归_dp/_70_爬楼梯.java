package com.lee.递归_dp;

public class _70_爬楼梯 {
    //每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    //输入： 2
    //输出： 2
    public int climbStairs(int n) {
        //dp[i]的定义：爬到第i层楼梯，有dp[i]中方法。
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <=n ; i++) {
        dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
