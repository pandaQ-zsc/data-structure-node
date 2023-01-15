package com.leecode.高频题;

import java.util.Arrays;

public class _322_零钱兑换 {
    //dp[i] 组成金额i所需最少硬币的个数。
    public int coinChange(int[] coins, int amount) {
        // dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        // 如果不填充一个amount+1，那所有的dp都会取0
        //这里 max = Integer.MAX会溢出 得到负数 ，
//        int max = amount+1;
      int max = 1000;
      int [] dp = new int[amount + 1];
      Arrays.sort(coins);
      Arrays.fill(dp,max);
      dp[0] = 0;
        for (int i = 1; i <=amount ; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i ){
                  dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
