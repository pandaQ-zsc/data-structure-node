package com.leecode.贪心;

public class _714_买卖股票的最佳时机含手续费 {
    //输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
    //输出：8
    //解释：能够达到的最大利润:
    //在此处买入 prices[0] = 1
    //在此处卖出 prices[3] = 8
    //在此处买入 prices[4] = 4
    //在此处卖出 prices[5] = 9
    //总利润 ((8 - 1) - 2) + ((9 - 4) - 2) = 8
    //
    //输入：prices = [1,3,7,5,10,3], fee = 3
    //输出：6
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        // 定义二维数组 dp[n][2]：
        //
        //dp[i][0] 表示第i天不持有可获得的最大利润；
        //dp[i][1] 表示第i天持有可获得的最大利润（注意是第i天持有，而不是第i天买入）。
        //
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i <len ; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);

        }
        return dp[len-1][0];
    }
}
