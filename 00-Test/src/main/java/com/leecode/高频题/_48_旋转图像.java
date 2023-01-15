package com.leecode.高频题;

public class _48_旋转图像 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //水平翻转
        for (int i = 0; i < n>>1 ; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[n-i-1][j];
                matrix[n-i-1][j] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        //对角线翻转
        for (int i = 0; i < n; i++) {
            //注意这里需要判断边界条件
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
