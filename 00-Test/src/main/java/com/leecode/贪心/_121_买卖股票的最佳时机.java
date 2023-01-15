package com.leecode.贪心;

//输入：[7,1,5,3,6,4]
//输出：5
public class _121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int max = 0;
        int min = prices[0];
        for (int i = 1; i <prices.length ; i++) {
            if (prices[i] < min){
                min = prices[i];
            }else {
                max = Math.max(max,prices[i]-min);
            }
        }
        return max;
    }
}
