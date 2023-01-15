package com.sort;

import javax.swing.*;
import java.util.Random;

public class _912_排序数组_test {
    public static int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid  = partition(nums,start,end);
        quickSort(nums,start,mid-1);
        quickSort(nums,mid+1,end);
    }

    private static int partition(int[] nums, int start, int end) {
        swap(nums,start,start +  new Random().nextInt(end-start+1));
        int pivot = nums[start];
        int mark = start;
        for (int i = mark+1; i <= end; i++) {
            if (nums[i] <= pivot){
                mark++;
                swap(nums,mark,i);
            }
        }
        swap(nums,start,mark);
        return mark;
    }

//    private static int partition(int[] nums, int start, int end) {
//      swap(nums,start,start + (int)(Math.random()*(end-start)));
//        swap(nums,start,new Random().nextInt(end-start+1)+start);

//        int pivot = nums[start];
//        int mark = start;
//        for (int i = mark + 1; i <= end; i++) {
//            if (nums[i] <= pivot) {
//                mark++;
//                swap(nums, mark, i);
//            }
//        }
//        swap(nums, mark, start);
//        return mark;
//    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }
}

