package com.mj;

import java.util.Arrays;

public class Main4 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {3, 4, 5}, {6, 7, 8}};
        System.out.println(Arrays.toString(arr[0]));
        System.out.println(arr[2]);
        System.out.println(arr[1]);

        int[] tt = new int[]{2, 3, 4, 5, 77, 99, 100};

        int index = search2(tt, 2);
        System.out.println("search binary value  --- > " + index);

    }


    //   二分查找的前提是需要有序
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        //  区间为 [] 需要考虑  left == right情况 
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int search2(int[] arr2, int target) {
        int left = 0;
        int right = arr2.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr2[mid] == target) {
                return mid;
            } else if (arr2[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


}
