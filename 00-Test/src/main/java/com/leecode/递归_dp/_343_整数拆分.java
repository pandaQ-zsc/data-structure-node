package com.leecode.递归_dp;

//给定一个正整数 n，将其拆分为至少两个正整数的和，
// 并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

//输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
public class _343_整数拆分 {
    //dp[i] 表示将正整数 i 拆分成至少两个正整数的和之后.这些正整数的最大乘积
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                int tmp = Math.max((i-j)*j,dp[i-j]*j);
                curMax=Math.max(curMax,tmp);
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

    public int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                int tmp = Math.max(j * (i - j), j * dp[i - j]);
                curMax = Math.max(curMax, tmp);
            }
            dp[i] = curMax;

        }
        return dp[n];
    }
}
