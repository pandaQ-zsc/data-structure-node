package com.sort;

import java.util.Arrays;

//https://leetcode-cn.com/problems/sort-an-array/solution/912-pai-xu-shu-zu-kuai-pai-zhi-shuang-bi-9z8h/
//https://www.runoob.com/w3cnote/merge-sort.html
//https://www.cnblogs.com/chengxiao/p/6194356.html
public class MergeSort_test {
    public static void main(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1};
        //【Example : sky】
        int a[] = {80,30,60,20,10,60,50,70};
//	int a[] = {10,20,30,40,50,60};
        sort(a);
        System.out.println(Arrays.toString(a));
        int[] copyOfRange = Arrays.copyOfRange(arr, 0, 3);
        System.out.println(Arrays.toString(copyOfRange));

    }
    public static void sort(int []arr){
        int[] res = new int[arr.length];
        int i=0,j=arr.length-1;
        sort(arr,res,i,j);
    }
    public static void sort(int[] arr , int[] res ,int l, int r){
        if (l < r){
            int mid =  l + (r-l)/2;
            sort(arr,res,l,mid);
            sort(arr,res,mid+1,r);
            merge(arr,l,mid,r,res);
        }
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid+1;
        int index = 0;
        while(i <= mid && j<=right){
            if (arr[i] <= arr[j]){
                temp[index++] = arr[i++];
            }else {
                temp[index++] = arr[j++];
            }
        }
        while(i <= mid){
           temp[index++] = arr[i++];
        }
        while (j <=right){
            temp[index++] = arr[j++];
        }
        index = 0;
        while(left <= right){
            arr[left++] =temp[index++];
        }

    }
}
