package com.lee.asia;

import cn.hutool.core.util.ArrayUtil;

/**
 * @author: xiong.qiang
 * @date: 2023/5/17 17:25
 */
public class _240_Search2DMatrixII {


    public static boolean searchMatrix(int[][] matrix, int target) {
        // Note : It passes but inefficient

//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == target) return true;
//            }
//        }
//        return false;

        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;
        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col]) return true;
            else if (target < matrix[row][col]) col--;
            else row++;
        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;
        while (col >= 0 && row < matrix.length) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] == target) {
                return true;
            } else {
                row++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
//        int[][] a = new int[][]{
//                {1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
//        System.out.println(ArrayUtil.toString(a));
//        boolean res = searchMatrix2(a, 5);
//        System.out.println("res ===>  " + res);
        int[][] b = new int[][]{{-5}};
        System.out.println(searchMatrix2(b, -5));
    }

}
