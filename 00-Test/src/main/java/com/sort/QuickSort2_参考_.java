package com.sort;

import java.util.Random;
////https://leetcode-cn.com/problems/sort-an-array/solution/912-pai-xu-shu-zu-kuai-pai-zhi-shuang-bi-9z8h/

/**
 * 快速排序
 */
public class QuickSort2_参考_ {
    public static int[] sortArray(int[] nums) {
        quickSort(0, nums.length, nums);
        return nums;
    }

    private static void quickSort(int l, int r, int[] nums) {
        if (l >= r) return;
        //[)
        int mid = pivotIndex(l, r, nums);
        quickSort(l, mid, nums);
        quickSort(mid + 1, r, nums);
    }

    private static int pivotIndex(int l, int r, int[] nums) {

        swap(l, l + (int)(Math.random()*(r - l)),nums);
        int pivot = nums[l];
        r--;
        while (l < r) {
            while(l < r){	// 从右往左扫描
                if(nums[r]>pivot){ // 右边元素 > 轴点元素
                    r--;
                }else{ // 右边元素 <= 轴点元素
                    nums[l++] = nums[r];
                    break;
                }
            }
            while(l < r){ // 从左往右扫描
                if(nums[l]<pivot){ // 左边元素 < 轴点元素
                    l++;
                }else{ // 左边元素 >= 轴点元素
                    nums[r--] = nums[l];
                    break;
                }
            }
        }
        nums[l] = pivot;
        return l;
    }

    private static void swap(int l, int r,int[] nums) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

}
