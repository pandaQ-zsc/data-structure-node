package com.lee.asia;

import java.util.ArrayList;
import java.util.List;

public class _54_螺旋矩阵 {
    //输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
    //输出：[1,2,3,6,9,8,7,4,5]
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) return null;
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int top = 0, bottom = matrix.length, left = 0, right = matrix[0].length;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (top > bottom || left > right) break;
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (top > bottom || left > right) break;
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if (top > bottom || left > right) break;
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (top > bottom || left > right) break;
        }
        return res;
    }

}
