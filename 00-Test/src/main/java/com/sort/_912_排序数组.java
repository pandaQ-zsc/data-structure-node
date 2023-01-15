package com.sort;

public class _912_排序数组 {
    public static int[] sortArray(int[] nums) {
        quickSort(0, nums.length, nums);
        return nums;
    }

    private static void quickSort(int l, int r, int[] nums) {
        if (r - l < 2) return;
        //[)
        int mid = pivotIndex(l, r, nums);
        quickSort(l, mid, nums);
        quickSort(mid + 1, r, nums);
    }
    //private static int partition(int[] nums, int start, int end) {
    //        swap(nums,start,start + (int)(Math.random()*(end-start)));

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

    private static int pivotIndex(int l, int r, int[] nums) {
        swap(l, l + (int)Math.random()*(r - l),nums);
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

