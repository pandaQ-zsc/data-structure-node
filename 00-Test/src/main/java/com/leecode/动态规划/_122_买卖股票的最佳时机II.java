package com.leecode.动态规划;

public class _122_买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {
        int[][]dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }
    public int maxProfit3(int[] prices) {
       int res = 0;
        for (int i = 1; i <prices.length ; i++) {
            if (prices[i] > prices[i-1]){
                res += prices[i] - prices[i-1];
            }else {
                res += 0;
            }
        }
        return res;
    }
    //不能同时参与多笔交易，所以每天交易结束只有持有一只股票和没有股票两种状态
    //我们使用dp[i][0] 表示第i天交易完成后没有持股的最大利润，
    // dp[i][1] 表示第i天交易完成后持股的最大利润.
    public int maxProfit2(int[] prices) {
        // [天数][是否持有股票]
        int[][] dp = new int[prices.length][2];

        //观察两种情况我们发现我们今天的利润只和前一天相关，我们需要记录前一天的利润。
        //那么对于第一天来说dp[0][0] = 0,dp[0][1] = -prices[0]因为第一天利润为0，花钱买入所以为负值
        //那么最后一天dp[n][0],dp[n][1]则肯定是全部卖出不持股钱最多。
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            // dp公式
            //第一种dp[i][0]，说明第i天没有持股，此时有两种可能，第i-1天没有持股，然后今天也没有买入交易，则利润为dp[i-1][0]，或者第i-1天持有股票，在今天卖出，利润为dp[i-1][1]+prices[i];
            //所以dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i])
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//            第二种情况dp[i][1],说明第i天持有股票，此时有两种可能，第i-1天就持有股票，今天保持不动没有交易，则利润为dp[i-1][1],或者第i-1天没有持股，是在今天买入了一支股票,则利润为dp[i-1][0] - prices[i];
//            所以dp[i][1] = max(dp[i-1][1],dp[i-1][0]-prices[i])
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }

}
