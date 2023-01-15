package com.leecode.动态规划;

public class _63_不同路径II {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
       if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
       int m = obstacleGrid.length;
       int n = obstacleGrid[0].length;
       int[][] dp = new int[m][n];
       //初始化
        for (int i = 0; i <m && obstacleGrid[i][0] != 1 ; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <n && obstacleGrid[0][j] != 1; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
       return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] ob  = new int[][]{};
        int i = uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        System.out.println(i);

    }


    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid ==null || obstacleGrid.length == 0 )return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        //确定dp含义
        // dp[i][j] : 从(0, 0)到(i, j) 有dp[i][j] 条不同的路径

        //初始化值
        for (int i = 0; i < row && obstacleGrid[i][0] != 1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < col && obstacleGrid[0][j] != 1; j++) {
            dp[0][j] = 1;
        }
        //状态转移推导
        for (int i = 1; i < row; i++) {
            for (int j = 1; j <col; j++) {
                if (obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[row-1][col-1];
    }
}
