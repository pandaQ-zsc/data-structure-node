package com.lee.asia;


import java.util.Arrays;

/**
 * @author Xiong Qiang
 * @date 2024/9/22 17:25
 */

public class _45_跳跃游戏II {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(minJump(nums)); // 输出结果
    }
    public static int minJump(int[] nums) {
        // 初始化 DP 数组
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE); // 将 DP 数组所有元素初始化为最大整数值
        dp[0] = 0; // 初始位置不需要跳跃即可到达

        // 动态规划求解
        for (int i = 0; i < nums.length; i++) {
            // 计算从当前位置 i 可以跳跃的最大步数
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < nums.length) {
                    // 更新跳跃后的索引 i + j 的值
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }

        // 返回到达最后一个位置所需的最小跳跃次数
        return dp[nums.length - 1];
    }
    public static int minJump2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <=nums[i] ; j++) {
                dp[i+j] = Math.min(dp[i+j],dp[i]+1);
            }
        }
        return dp[nums.length-1];
    }

}
