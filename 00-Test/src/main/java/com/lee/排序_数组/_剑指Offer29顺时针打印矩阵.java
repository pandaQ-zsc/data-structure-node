package com.lee.排序_数组;


public class _剑指Offer29顺时针打印矩阵 {
    public int[] spiralOrder(int[][] matrix) {
        //输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        //输出：[1,2,3,6,9,8,7,4,5]
        if (matrix.length == 0 )return  new int [0];
        int l = 0,r = matrix[0].length -1,t=0, b = matrix.length-1,x =0;
        int [] res = new int[(r+1) * (b + 1)] ;
        while(true){
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i];
            }
            if (++t > b)break;
            for (int i = t; i <=b ; i++) {
                res[x++] = matrix[i][r];
            }
            if (--r <l) break;
            for (int i = r; i >=l; i--) {
                res[x++]=matrix[b][i];
            }
            if (--b < t)break;
            for (int i = b; i >=t ; i--) {
                res[x++] = matrix[i][l];
            }
            if (++l > r)break;
        }
        return res;
    }
}
