package com.leecode.排序_数组;

public class _240_搜索二维矩阵 {
    //输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
    //输出：true
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null){
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0 ;
        while(row < matrix.length && col >= 0){
            if (target == matrix[row][col]) return true;
            else if (target < matrix[row][col]) col--;
            else row ++;
        }
        return false;
    }



    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) {
            return false;
        }
        int row = 0 ;
        int col = matrix[0].length -1;
        //TODO: col这里需要 >=
        while(  row< matrix.length && col >= 0 ){
            if (target==matrix[row][col]) return true;
            else if (target > matrix[row][col]  ) row ++ ;
            else col--;
        }
        return false;
    }


}
