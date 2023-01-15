package com.leecode.递归_dp;

public class _509_斐波那契数 {
    //  0 1 2 3 4 5 6
    //  0 1 1 2 3 5 8
    public int fib2(int n) {
        if (n < 2) return n;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n ; i++) {
            c =  a + b;
            a = b;
            b = c ;
        }
        return c;

    }
    public int fib(int n) {
        if (n < 2) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <=n ; i++) {
            dp[i] = dp[i -1] + dp[i-2];
        }
        return dp[n];

    }
}
