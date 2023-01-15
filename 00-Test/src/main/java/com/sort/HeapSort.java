package com.sort;

import java.util.Arrays;
//https://leetcode-cn.com/problems/sort-an-array/solution/912-pai-xu-shu-zu-kuai-pai-zhi-shuang-bi-9z8h/
//https://www.cnblogs.com/chengxiao/p/6129630.html
public class HeapSort {
    public static void main(String []args){
        int []arr = {9,8,7,6,10,4,10,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for(int i = arr.length/2-1 ; i>=0;i--){
            adjustHeap(arr,i, arr.length);
        }
        for(int i = arr.length-1;i>0;i--){
            swap(arr,0,i);
            adjustHeap(arr,0,i);
        }
    }

    private static void adjustHeap(int[] arr, int i, int length) {
        int tmp = arr[i];
        for(int k = 2*i+1;k<length;k = 2*k+1 ){
            if (k+1<length && arr[k+1] >arr[k] ){
                k++;
            }
            if (arr[k]>arr[i]){
                swap(arr,k,i);
                i = k;
            }else {
                break;
            }
        }
        arr[i] = tmp;
    }
    private static void swap (int[]arr,int l, int r){
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }


}


