package com.lee.asia;

import cn.hutool.core.util.ArrayUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: xiong.qiang
 * @date: 2023/5/15 17:39
 */
public class _566_ReshapetheMatrix {

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                count++;
                queue.add(mat[i][j]);
            }
        }
        if (count != r*c){
            return mat;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!queue.isEmpty()){
                    res[i][j] = queue.poll();
                }
            }
        }
        return res;
    }

//    public static int[][] matrixReshape2(int[][] mat, int r, int c) {
//        int
//
//    }


    //Input: mat = [[1,2],[3,4]], r = 1, c = 4
    //Output: [[1,2,3,4]]

    //Input: mat = [[1,2],[3,4]], r = 2, c = 4
    //Output: [[1,2],[3,4]]
    public static void main(String[] args) {
             int[][] a = new int[][]{{1,2},{3,4}};
        matrixReshape(a, 1, 4);
        System.out.println(Arrays.toString(a));
        System.out.println(ArrayUtil.toString(a));
    }
}
