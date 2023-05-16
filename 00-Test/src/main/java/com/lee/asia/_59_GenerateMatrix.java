package com.lee.asia;

/**
 * @author: xiong.qiang
 * @date: 2023/3/24 13:58
 */

//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。

//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]

//输入：n = 1
//输出：[[1]]

public class _59_GenerateMatrix {
    public static int[][] generateMatrix(int n) {
        //当前循环圈数
        int loop = 1;
        int i, j;
        int start = 0;  // 每次循环的起点
        int[][] res = new int[n][n];
        int count = 1; // 每次填写的数字
        //// loop的值：代表每个圈循环几次，例如n为奇数3，那么loop = 1 只是循环一圈，矩阵中间的值需要单独处理
        //  当n=3的时候 每个方向先走两步
        while (loop <= n / 2) {
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }
            while (j >= loop) {
                res[i][j] = count++;
                j--;
            }
            while (i >= loop) {
                res[i][j] = count++;
                i--;
            }
            start++;
            loop++;

        }
        if (n % 2 == 1) {
            res[start][start] = count;
        }
        return res;

    }

    public static int[][] generateMatrix3(int n) {
        int start = 0 , loop = 1, i,j;
        int count = 1;
        int[][] res = new int[n][n];
        while( loop <= n/2 ){
            for(j = start; j < n-loop;j++){
                res[start][j] = count++;
            }
            for (i = start; i < n-loop;i++){
                res[i][j] = count++;
            }
            while(j >= loop){
                res[i][j] = count++;
                j--;
            }
            while(i >= loop ){
                res[i][j] = count++;
                i--;
            }
            start++;
            loop++;
        }
        if (n%2 ==1){
        res[start][start] = count;
        }
        return res;
    }


    //initial  leetcode  pre
    public static int[][] generateMatrix2(int n) {
        int loop = 1;
        int i, j;
        int start = 0;  // 每次循环的起点
        int res[][] = new int[n][n];
        int count = 1; // 每次填写的数字
        //// 每个圈循环几次，例如n为奇数3，那么loop = 1 只是循环一圈，矩阵中间的值需要单独处理

        while (loop <= n / 2) {
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }
            while (j >= loop) {
                res[i][j] = count++;
                j--;
            }
            while (i >= loop) {
                res[i][j] = count++;
                i--;
            }
            start++;
            loop++;

        }
        if (n % 2 == 1) {
            res[start][start] = count;
        }
        return res;

    }


    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printArray(arr);
        System.out.println("================");
        int[][] ints = generateMatrix3(4);
        printArray(ints);
        System.out.println("================");
//        int[][] intTest = generateMatrix3(4);
//        printArray(intTest);
    }
}