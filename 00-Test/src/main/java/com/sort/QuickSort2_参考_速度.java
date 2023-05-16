package com.sort;

import java.util.Random;

/**
 * 快速排序
 */
//https://leetcode-cn.com/problems/sort-an-array/solution/912-pai-xu-shu-zu-kuai-pai-zhi-shuang-bi-9z8h/
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    //快速排序主函数
    public void quickSort(int[] nums, int low, int high) {
        //递归终止条件
        if (low >= high) {
            return;
        }
        int mid = partition(nums, low, high);
        quickSort(nums, low, mid - 1);
        quickSort(nums, mid + 1, high);

    }
    //分割
    //也就是每次确定一个元素， 将数组中比这个元素小的放左边   数组中比这个元素大的放右边
    public int partition(int[] nums, int start, int end) {
        swap(nums,start,start + (int)(Math.random()*(end-start)));
        int pivot = nums[start];
        int left = start;//不能从start+1开始，否则当只有两个数时，无论大小都会交换
        int right = end;
        //只能从右往左，再从左往右，不能相反
        // 因为如果先从左边开始找比基准点小的话最后会造成
        //把大的元素交换到基准点左边去， 导致逻辑不正确
        while (left < right) {
            //如果没有left<right会left++直到出现left>right的情况,这时候交换的会是错误的值
            while (left < right && nums[right] > pivot) {//也可以写nums[right]>=pivot无影响
                right--;
            }
            //如果此時left<pivot 會有一种情况就是 left pivot最开始指向同一个元素
            //就会直接跳过while循环在后面直接将left 和right交换了把基准点元素交换走了。
            //而不是先进行left++后再进行比较。
            while (left < right && nums[left] <= pivot) {
                //如果没有left<right会出现left>right的情况
                left++;
            }
            //结束两个子循环会有两种情况，只有left小于right时，才进行交换
            swap(nums, left, right);
        }
        //此时跳出while循环，只可能是left等于right，不会有left>right的情况
        //接下来的交换和返回，写left或者right都行，因为两者相等
        swap(nums, start, left);
        return left;
    }

    public int partition2(int[] nums, int start, int end) {
        //end-start+1  [0,end-start+1)
//        swap(nums,start,start + (int)(Math.random()*(end-start)));

        int random = new Random().nextInt(end - start + 1) + start;
        swap(nums, random, start);
        int pivot = nums[start];
        //mark记录小于等于pivot元素的边界 【mark主要是用来找位置的】
        int mark = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] <= pivot) {
                //有符合的元素则mark加一
                mark++;
                //交换当前元素和mark位置的元素  --这里只是交换值 mark索引不交换
                swap(nums, mark, i);
            }
        }
        //此时mark索引以左包括mark本身，全部是小于等于pivot的元素
        //【mark找到位置后】将start[pivot]和mark位置对应的值交换。是的mark位置为pivot
        swap(nums, mark, start);
        return mark;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


//单边循环
public class QuickSort2_参考_速度 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int low, int high) {
        //递归终止条件
        if (low >= high) {
            return;
        }
        int mid = partition(nums, low, high);
        quickSort(nums, low, mid - 1);
        quickSort(nums, mid + 1, high);

    }

    public int partition(int[] nums, int start, int end) {
        //end-start+1  [0,end-start+1)
//        swap(nums,start,start + (int)(Math.random()*(end-start)));

        int random = new Random().nextInt(end - start + 1) + start;
        swap(nums, random, start);
        int pivot = nums[start];
        //mark记录小于等于pivot元素的边界 【mark主要是用来找位置的】
        int mark = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] <= pivot) {
                //有符合的元素则mark加一
                mark++;
                //交换当前元素和mark位置的元素  --这里只是交换值 mark索引不交换
                swap(nums, mark, i);
            }
        }
        //此时mark索引以左包括mark本身，全部是小于等于pivot的元素
        //【mark找到位置后】将start[pivot]和mark位置对应的值交换。是的mark位置为pivot
        swap(nums, mark, start);
        return mark;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
