package com.sort;

import java.util.Arrays;


public class MergeSort_leecode2_good_simple {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        //        int a[] = {60,50,40,30,20,10};
        int a[] = {30, 40, 60, 10, 20, 50};
//        int a[] = {10, 20, 30, 40, 50, 60};
        System.out.println(Arrays.toString(a));
        int[] ints = mergeSorting(a);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] mergeSorting(int[] nums){
        if (nums.length <= 1) {
            return nums;
        }
        int num = nums.length >> 1;
        int[] left = Arrays.copyOfRange(nums, 0, num);
        int[] right = Arrays.copyOfRange(nums, num, nums.length);
        return merge(mergeSorting(left), mergeSorting(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[left.length + right.length];

        while(i < left.length && j < right.length){
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
}
