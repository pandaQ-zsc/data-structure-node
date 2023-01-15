package com.sort;

import java.util.Arrays;

////https://leetcode-cn.com/problems/sort-an-array/solution/912-pai-xu-shu-zu-kuai-pai-zhi-shuang-bi-9z8h/
//https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/kuai-pai-dui-pai-shou-xie-xiao-ding-dui-c6e2t/
public class _215_heapSort_数组中的第K个最大元素 {
    //给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
    //请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第k个不同的元素。
    //输入: [3,2,1,5,6,4] 和 k = 2
    //输出: 5
    //输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
    //输出: 4


    ///K个元素的小堆顶的堆顶就是第K大元素
    public static int findKthLargest(int[] nums, int k) {
        //大顶堆
        for(int i = nums.length/2 -1; i >= 0 ; i--){
            heapify(nums,i,nums.length);
        }
        for (int i = nums.length-1; i >0 ; i--) {
            swap(nums,0,i);
            heapify(nums,0,i);
        }
        return nums[nums.length-k];
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void heapify(int[] nums, int i, int length) {
        int tmp = nums[i];
        for (int k = 2*i+1; k <length ; k = k*2+1) {
            if (k+1<length && nums[k+1] > nums[k]){
                k++;
            }
            if (nums[k]> tmp){
                swap(nums,k,i);
                i = k;
            }else {
                break;
            }
        }
        nums[i] = tmp;
    }
    public static void main(String []args){
        int []arr = {3,2,1,5,6,4};
        int kthLargest = findKthLargest(arr, 2);
        System.out.println(kthLargest);
        System.out.println(Arrays.toString(arr));
    }
}
