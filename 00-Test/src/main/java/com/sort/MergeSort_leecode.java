package com.sort;

import java.util.Arrays;

//https://www.runoob.com/w3cnote/merge-sort.html
//https://www.cnblogs.com/chengxiao/p/6194356.html

//算法步骤
//申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
//
//设定两个指针，最初位置分别为两个已经排序序列的起始位置；
//
//比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
//
//重复步骤 3 直到某一指针达到序列尾；
//
//将另一序列剩下的所有元素直接复制到合并序列尾。
public class MergeSort_leecode {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        //        int a[] = {60,50,40,30,20,10};
        int a[] = {30, 40, 60, 10, 20, 50};
//        int a[] = {10, 20, 30, 40, 50, 60};
        sortArray(a);
        System.out.println(Arrays.toString(a));
    }

    //避免函数中传递
    static int[] tmp;

    public static int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }


    private static void mergeSort(int[] nums, int l, int r) {
        //case : 【】
        // 最小归并[0,1] 两个开始  ---> [0,3] 四个排序---> [0,7] 八个排序
        if (l < r) {
            int mid = (l + r) >> 1;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            merge(nums, l, r);
        }
    }

    private static void merge(int[] nums, int l, int r) {
        int mid = (l + r) >> 1;
        int i = l;
        int j = mid + 1;
        int cur = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[cur++] = nums[i++];
            } else {
                tmp[cur++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[cur++] = nums[i++];
        }
        while (j <= r) {
            tmp[cur++] = nums[j++];
        }
        cur = 0;
        //将临时数组中的元素放回nums数组中
        while (l <= r) {
            //细节问题：temp临时数组每次使用都是从0开始储存，而nums则是从left到right
            nums[l++] = tmp[cur++];
        }
    }
}
