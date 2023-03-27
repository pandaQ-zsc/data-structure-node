package com.lee.asia;

//股票系列问题 dp写法
//https://leetcode-cn.com/circle/article/qiAgHn/
public class _121_买卖股票的最佳时机 {
    //输入：[7,1,5,3,6,4]
    //输出：5
    //  1,6
    //输入：prices = [7,6,4,3,1]
    //输出：0

    //记录【今天之前买入的最小值】
    //计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
    //比较【每天的最大获利】，取最大值即可
    public int maxProfit2(int[] prices) {
        if (prices.length < 2) return 0;
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }


    public int maxProfit(int[] prices) {
        int max = 0;
        int minNum = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minNum) {
                max = Math.max(max, prices[i] - minNum);
            } else {
                minNum = prices[i];
            }
        }
        return max;
    }
}
