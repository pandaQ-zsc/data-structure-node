package com.lee.贪心;

//输入: prices = [7,1,5,3,6,4]
//输出: 7
//
//输入: prices = [1,2,3,4,5]
//输出: 4
public class _122_买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]>prices[i-1]){
                res += prices[i] - prices[i-1];
            }else {
                res += 0;
            }
        }
        return res;
    }
}
