package com.sort;

//https://www.runoob.com/w3cnote/merge-sort.html
//https://www.cnblogs.com/chengxiao/p/6194356.html
public class MergeSort_test2 {
    int[] tmp;
    public int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums,0,nums.length-1);
        return nums;
    }


    private void mergeSort(int[] nums, int l, int r) {
        //   if(left >= right){
        //            return;
        //        }
        if (l < r){
            int mid = (l + r) >> 1;
            mergeSort(nums,l,mid);
            mergeSort(nums,mid+1,r);
            merge(nums,l,r);
        }
    }

    private void merge(int[] nums, int l, int r) {
        int mid = (l + r) >> 1;
        int i1 = l;
        int i2 = mid+1;
        int cur =0;
        while(i1 <= mid &&i2<=r){
            if (nums[i1] <= nums[i2]){
                tmp[cur++] = nums[i1++];
            }else {
                tmp[cur++] = nums[i2++];
            }
        }
        while(i1 <=mid){
            tmp[cur++] = nums[i1++];
        }
        while(i2<=r){
            tmp[cur++] = nums[i2++];
        }
        cur=0;
        while(l <= r){
            nums[l++] =tmp[cur++];
        }
    }
}
