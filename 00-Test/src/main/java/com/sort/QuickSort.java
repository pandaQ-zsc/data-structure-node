package com.sort;

import java.io.FileReader;

/**
 * 快速排序：Java
 *
 * @author skywang
 * @date 2014/03/11
 */

public class QuickSort {

    /*
     * 快速排序
     *
     * 参数说明：
     *     a -- 待排序的数组
     *     l -- 数组的左边界(例如，从起始位置开始排序，则l=0)
     *     r -- 数组的右边界(例如，排序截至到数组末尾，则r=a.length-1)
     */
    public static void quickSort(int[] a, int l, int r) {
        //将 quickSort(a, l, i - 1) 后不符合边界条件的 递归去掉。
        if (l < r) {
            int i, j, x;
            i = l;
            j = r;
            x = a[i];
            // 每次循环结束时：也就是i = j时确定了基准元素位置
            while (i < j) {
                while (i < j && a[j] > x) {
                    j--; // 从右向左找第一个小于x的数
                }
                if (i < j) {
                    a[i++] = a[j];
                }
                while (i < j && a[i] < x) {
                    i++; // 从左向右找第一个大于x的数
                }
                if (i < j) {
                    a[j--] = a[i];
                }
            }
            a[i] = x;
            //运行到这里： i 就已经等于 j 了
            quickSort(a, l, i - 1); /* 递归调用 */
            quickSort(a, i + 1, r); /* 递归调用 */
        }
    }

    public static void quickSort2(int[] a, int l, int r) {
        if (l<r){
            int i = l, j = r ,tmp = a[i];
            while (i < j){
                while(i<j && a[j] > tmp){
                    j--;
                }
                if (i<j){
                    a[i++]  = a[j];
                }
                while(i<j && tmp >a[i]){
                    i++;
                }
                if (i<j){
                    a[j--] = a[i];
                }
            }
            a[i] = tmp;
            quickSort2(a,l,i-1);
            quickSort2(a,j+1,r);
        }
    }


    public static void main(String[] args) {
        int i;
//        int a[] = {60,50,40,30,20,10};
        int a[] = {30, 40, 60, 10, 20, 50};
//        int a[] = {10, 20, 30, 40, 50, 60};
        // ----------------------------------------------other case-------------------------------------------------
        //用于测试while(i < j)的特殊情况：在这种情况下，i 和 j 最初的值就相等，循环条件不满足，不会进入循环体。由于所有元素相等，不需要进行交换操作，直接跳过这个循环即可。但这是一个特殊情况，一般情况下 while (i < j) 循环是必须的，以确保快速排序算法的正确性和稳定性。
//	int a[] = {10,10,10,10,10,10};

        System.out.printf("【Quick sort】 before sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");

        quickSort2(a, 0, a.length - 1);

        System.out.printf("【Quick sort】 after  sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");
    }
}