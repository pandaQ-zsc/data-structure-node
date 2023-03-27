package com.lee.排序_数组;

public class _566_重塑矩阵 {
    //输入：mat = [[1,2],[3,4]], r = 1, c = 4
    //输出：[[1,2,3,4]]
    //  n  = nums[0].length
    //  index / n  行号
    //  index % n  列号
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int [][] res = new int[r][c];
        int row = mat.length;
        int col = mat[0].length;
        if (col * row != r * c ){
            return mat;
        }
        int index = 0 ;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 新数据 [][] =  原本的数据[][]
                res[i][j] = mat[index/col][index%col];
                index ++;
            }
        }
        return res;
    }
}
