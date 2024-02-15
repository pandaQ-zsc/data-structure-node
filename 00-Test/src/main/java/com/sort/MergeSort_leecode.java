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
//        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        //        int a[] = {60,50,40,30,20,10};
//        int a[] = {10, 20, 30, 40, 50, 60};
        //hello algo
        int a[] = {7,3,2,6,0,1,5,4};
        System.out.println(Arrays.toString(a));
        int[] res = sortArray(a);
        System.out.println(Arrays.toString(res));
    }

    //避免函数中传递
    static int[] tmp;

    public static int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }


    private static void mergeSort(int[] nums, int l, int r) {
        // 终止条件
//        if (left >= right)
//            return;                      // 当子数组长度为 1 时终止递归
        //case : 【】
        // 最小归并[0,1] 两个开始  ---> [0,3] 四个排序---> [0,7] 八个排序
        if (l < r) {
            int mid = (l + r) >> 1;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            merge2(nums, l, r);
        }
    }

    private static void merge(int[] nums, int l, int r) {
        int mid = (l + r) >> 1;
        //保留 l 的值 留给后面将tmp值存储到nums中
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
            tmp[cur++] = nums[i++];//将左边剩余元素填充进tmp中
        }
        while (j <= r) {
            tmp[cur++] = nums[j++];//将右边剩余元素填充进tmp中
        }
        //将临时数组中的元素放回nums数组中
        cur = 0;
        //此时【l ~ r】的范围就是每次需要合并的子序列范围
        while (l <= r) {
//        error :while(l < r){     ans: l:0, r:1 的时候虽然是相差1 但是因为有两个索引  所以应该移动两次的
            //细节问题：temp临时数组每次使用都是从0开始储存，
            // 而nums则是从left到right(由于归并子序列都是从l开始的)
            nums[l++] = tmp[cur++];
        }
    }

    private static void merge2(int[] nums, int l, int r) {
        int mid = (l + r) >>1;
        int i = l ,j =mid+1;
        int cur = 0;
        while(i<= mid && j <= r){
            if (nums[i] <= nums[j]){
                tmp[cur++]  = nums[i++];
            }else{
                tmp[cur++] = nums[j++];
            }
        }
        while(i<=mid){
            tmp[cur++] = nums[i++];
        }
        while(j<=r){
            tmp[cur++] = nums[j++];
        }
        cur=0;
        while(l<=r){
            nums[l++] = tmp[cur++];
        }
    }

}
