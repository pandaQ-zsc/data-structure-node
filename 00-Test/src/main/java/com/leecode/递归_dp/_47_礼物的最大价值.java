package com.leecode.递归_dp;

public class _47_礼物的最大价值 {
    public int maxValue(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        // 0行
        for (int col = 1; col < cols; col++) {
            dp[0][col] = dp[0][col - 1] + grid[0][col];
        }
        // 0列
        for (int row = 1; row < rows; row++) {
            dp[row][0] = dp[row - 1][0] + grid[row][0];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}

