package com.sort;

import com.leecode.八大排序算法.Sort;

import java.util.Arrays;
import java.util.Random;
////https://leetcode-cn.com/problems/sort-an-array/solution/912-pai-xu-shu-zu-kuai-pai-zhi-shuang-bi-9z8h/
/**
 * 快速排序
 */
public class QuickSort_test {
    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    public static void main(String []args){
        int []arr = {5,3,7,2,9,8,1,4};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void  quickSort(int[] nums, int low, int high) {
        if (low >=high) return;
        int mid = partition(nums,low,high);
        quickSort(nums,low,mid-1);
        quickSort(nums,mid+1,high);
    }

    private static int partition(int[] nums, int start, int end) {
        swap(nums,start, (int) (start +(Math.random()* (end-start))));
      int pivot = nums[start];
      int tmp = start;
      while(start < end){
          while(start < end && nums[end]> pivot){
              end--;
          }
          while(start < end && nums[start] <= pivot){
              start++;
          }
          swap(nums,start,end);
      }
      swap(nums,tmp,start);
      return start;
    }
    private static int partition2(int[] nums, int start, int end) {
        swap(nums,start, (int) (start +(Math.random()* (end-start))));
        int pivot = nums[start];
        int mark = start;
        for (int i = mark+1; i <= end; i++) {
            if (nums[i] >= pivot){
                mark++;
                swap(nums,nums[i],mark);
            }
        }
        swap(nums,start,mark);
        return mark;
    }


        private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

}
