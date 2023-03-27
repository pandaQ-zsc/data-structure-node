package com.lee.asia;

/*
给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
与 标准答案 误差在 10-5 的结果都被视为正确结果。
输入：arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
输出：2.00000
解释：删除数组中最大和最小的元素后，所有元素都等于 2，所以平均值为 2 。

输入：arr = [9,7,8,7,7,8,4,4,6,8,8,7,6,8,8,9,2,6,0,0,1,10,8,6,3,3,5,1,10,9,0,7,10,0,10,4,1,10,6,9,3,6,0,0,2,7,0,6,7,2,9,7,7,3,0,1,6,1,10,3]
输出：5.27778

链接：https://leetcode.cn/problems/mean-of-array-after-removing-some-elements
*/

import java.util.Arrays;

public class _1619_删除某些元素后的数组均值 {

    /**
     * daeeqq
     * 排序后用5%开头 用95%结尾 最后用上90%的长度
     */

    public static void main(String[] args) {
        double v = trimMean(new int[]{6, 2, 7, 5, 1, 2, 0, 3, 10, 2, 5, 0, 5, 5, 0, 8, 7, 6, 8, 0});
        System.out.println(v);
    }

    public static double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, tot = Arrays.stream(arr, n / 20, n - n / 20).sum();
        return tot * 1.0 / (n * 0.9);
    }

    public static double trimMean2(int[] arr) {
        Arrays.sort(arr);
        double res = 0;
        for (int i = arr.length / 20; i < arr.length * 19 / 20; i++) {
            res += arr[i];
        }
        return res / (arr.length * 9 / 10);
    }
}

