package com.lee.递归_dp;

import java.util.Arrays;

//计算并返回可以凑成总金额所需的 最少的硬币个数 。
// 如果没有任何一种硬币组合能组成总金额，返回 -1 。
//输入：coins = [1, 2, 5], amount = 11
//输出：3
public class _322_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(amount <= 0) return -1;
        return coindp(coins,amount);
    }

    //状态：金额
    //转移：一个硬币，这个硬币的金额在coins[]数组中遍历
    //dp函数：输入金额，返回最少硬币数
    public int coindp(int[] coins, int amount){
        int[] dp = new int[amount+1];//最多的硬币情况是全部是1元，共有amount个硬币，共有amount+1个状态，amount+1个金额
        Arrays.fill(dp, amount+1);//必须将所有的dp赋最大值，因为要找最小值
        dp[0] = 0;//自底向上，金额为0，最小硬币数为0
        int[] mem = dp;
        for(int am = 1; am <= amount; am++){//自底向上
            for(int coin : coins){//遍历coins的金额
                if(am >= coin)//am-coin 必须大于0，否则数组溢出
                    dp[am] = Math.min(dp[am], dp[am-coin] + 1);//金额为11的最小硬币数 和 金额为(11-一个面值)的最小硬币数+1 比较最小值
            }
        }
        return dp[amount]>amount? -1: dp[amount];//返回金额为amount的最小硬币数 根据测试用例判断dp[amout]>amount
    }

    /**
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     */

    public int coinChange2(int[] coins, int amount) {
        Arrays.sort(coins);
        recursion(coins, amount, 0, coins.length - 1);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }
    int minCount = Integer.MAX_VALUE;
    /**
     * 1、按金额从大到小，从多到少（排序，用余数一步到位）
     * 2、预判低于最优解，终止递归（可以返回最优解，不过提升有限，意义不大）
     * 3、能整除即可返回
     *
     * k = amount / coins[index] 计算最大能投几个
     * amount - k * coins[index] 减去扔了 k 个硬币
     * count + k 加 k 个硬币
     *
     */

    void recursion(int[] coins, int amount, int count, int index) {
        if (index < 0 || count + amount / coins[index] >= minCount) return;
        if (amount % coins[index] == 0) {
            minCount = Math.min(minCount, count + amount / coins[index]);
            return;
        }
        for (int i = amount / coins[index]; i >= 0; i--) {
            recursion(coins, amount - i * coins[index], count + i, index - 1);
        }
    }
}
