package com.lee.递归_dp;

public class _96_不同的二叉搜索树 {

    //给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的
    // 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
    //输入：n = 3
    //输出：5

    //dp[i] ： 1到i为节点组成的二叉搜索树的个数为dp[i]。
    //j相当于是头结点的元素，从1遍历到i为止。
    public int numTrees(int n) {
       if (n <= 2) return  n ;
       int [] dp = new int[n+1];
       dp[0]= 1;
       dp[1] =1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //dp[2] = dp[0] * dp[1] + dp[1] * dp[0];
                //dp[3] = dp[2] * dp[0] + dp[1] * dp[1] + dp[0] * dp[2]
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
