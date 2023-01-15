package com.sort;

import java.util.Arrays;

//https://leetcode-cn.com/problems/sort-an-array/solution/912-pai-xu-shu-zu-kuai-pai-zhi-shuang-bi-9z8h/
//https://www.cnblogs.com/chengxiao/p/6129630.html
public class HeapSort_test {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] nums) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, len);
        }
        for (int i = len - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void adjustHeap(int[] nums, int i, int len) {
        int tmp = nums[i];
        for (int k = i * 2 + 1; k < len; k= k* 2+1) {
            if (k + 1 < len && nums[k] < nums[k + 1]) {
                k++;
            }
            if (nums[k] > nums[i]) {
                swap(nums, i, k);
                i = k;
            } else {
                break;
            }
        }
        nums[i] = tmp;
    }


}


