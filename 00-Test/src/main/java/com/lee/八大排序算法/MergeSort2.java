package com.lee.八大排序算法;

import java.util.Arrays;

//https://www.runoob.com/w3cnote/merge-sort.html
//https://www.cnblogs.com/chengxiao/p/6194356.html
public class MergeSort2 {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 2, 3, 4};
//        int[] arr = new int[]{1,2,5,2,1,7,10,21,1,3,5,21,44};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[] tmp = new int[arr.length];
        sort(arr, tmp, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int[] tmp, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            sort(arr, tmp, l, mid);
            sort(arr, tmp, mid + 1, r);
            merge(arr, tmp, l, r, mid);
        }

    }

    private static void merge(int[] arr, int[] tmp, int l, int r, int mid) {
        int i = l;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[t++] = arr[i++];
        }
        while (j <= r) {
            tmp[t++] = arr[j++];
        }
        t=0;
        while (l <= r){
            arr[l++] = tmp[t++];
        }

    }


}
