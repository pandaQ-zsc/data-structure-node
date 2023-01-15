package com.leecode.排序_数组;

public class _59_螺旋矩阵II {
    public int[][] generateMatrix(int n) {
        int l = 0 , r = n-1 , t = 0 , b = n-1;
        int target = n * n , num = 1;
        int[][] res = new int[n][n];
        while(num <= target){
            for (int i = l; i <=r ; i++) {
                res[t][i]=num++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                res[i][r] = num++;
            }
            r--;
            for (int i = r; i >= l ; i--) {
                 res[b][i] = num++;
            }
            b--;

            for (int i = b; i >= t; i--) {
               res[i][l] = num++;
            }
            l++;
        }
        return res;

    }
}
