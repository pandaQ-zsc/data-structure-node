package com.lee.asia;


/**
 * @author Xiong Qiang
 * @date 2024/9/21 15:40
 */

public class _122_买卖股票的最佳时机II {
    public static int maxProfit(int[] prices) {
        int res = 0;
        int n =prices.length;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i-1]){
                res += prices[i] - prices[i-1];
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
