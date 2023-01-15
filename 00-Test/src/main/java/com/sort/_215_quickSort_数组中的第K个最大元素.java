package com.sort;

import javax.naming.PartialResultException;
import java.util.Arrays;

////https://leetcode-cn.com/problems/sort-an-array/solution/912-pai-xu-shu-zu-kuai-pai-zhi-shuang-bi-9z8h/

//https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/kuai-pai-dui-pai-shou-xie-xiao-ding-dui-c6e2t/
public class _215_quickSort_数组中的第K个最大元素 {

    //输入: [3,2,1,5,6,4] 和 k = 2
    //输出: 5
    //输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
    //输出: 4

    public static int findKthLargest(int[] nums, int k) {
        quickSort(0,nums.length,nums);
        return nums[nums.length-k];
    }

    private static void quickSort(int l, int r, int[] nums) {
        if (r-l < 2 )return;
        //[)
        int mid = pivotIndex(l, r, nums);
        quickSort(l,mid,nums);
        quickSort(mid+1, r,nums);
    }

    private  static int pivotIndex(int l, int r, int[] nums) {
        int pivot = nums[l];
        r--;
        while(l < r){
            while(l<r && nums[l] <pivot) l++;
            nums[r] = nums[l];
            while(l<r && nums[r] >= pivot) r--;
            nums[l] = nums[r];
        }
        nums[l] = pivot;
        return l;
    }
    public static void main(String[] args) {
        int[] arrays = new int[]{3,2,1,5,6,4};
        findKthLargest(arrays, 3);
        for (int j = 0; j < arrays.length; j++) {
            System.out.print("_"+arrays[j]+"_");

        }
    }

}
