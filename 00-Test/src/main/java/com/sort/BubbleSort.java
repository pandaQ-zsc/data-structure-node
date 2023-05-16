package com.sort;

/**
 * 冒泡排序：Java
 *
 * @date 2023/03/11
 */

public class BubbleSort {

    /*
     * 冒泡排序
     *
     * 参数说明：
     *     a -- 待排序的数组
     *     n -- 数组的长度
     */
    public static void bubbleSort1(int[] a, int n) {
        for(int i = n-1;i>0;i--){
            int flag = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = 1;
                }
            }
            if (flag == 0){
                break;
            }
        }
    }

    public static void bubbleSort_test(int[] a, int n) {
        for (int i = n-1; i >0 ; i--) {
            int flag = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = 1;
                }
            }
            if (flag ==1) {
                break;
            }
        }
    }

    /*
     * 冒泡排序(改进版)
     *
     * 参数说明：
     *     a -- 待排序的数组
     *     n -- 数组的长度
     */
    public static void bubbleSort2(int[] a, int n) {
        for (int i = n - 1; i > 0; i--) {
           int  flag = 0;            // 初始化标记为0
            // 将a[0...i]中最大的数据放在末尾
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    // 交换a[j]和a[j+1]
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = 1;    // 若发生交换，则设标记为1
                }
            }
            if (flag == 0) {
                break;            // 若没发生交换，则说明数列已有序。
            }
        }
    }

    public static void main(String[] args) {
        int i;
//        int[] a = {20, 40, 30, 10, 60, 50};
        int a[] = {30, 40, 60, 10, 20, 50};
//        int a[] = {10,20,30,40,50,60};
        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");

//        bubbleSort_test(a, a.length);
//        bubbleSort1(a, a.length);
        bubbleSort1(a, a.length);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");
    }
}