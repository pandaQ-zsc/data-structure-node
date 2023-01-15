package com.leecode.排序_数组;

public class _70_爬楼梯 {
    //  f(x) = f(x-1) + f(x-2)   --->想到斐波那契数组

    public int climbStairs(int n) {
        int [] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i -2];
        }
        return dp[n];
    }

    public int climbStairs1(int n) {
        if (n <= 2){
            return  n ;
        }
        int f1 = 1,f2 = 2, f3 = 3;
        for (int i = 3; i <= n ; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return  f3;
    }
}
