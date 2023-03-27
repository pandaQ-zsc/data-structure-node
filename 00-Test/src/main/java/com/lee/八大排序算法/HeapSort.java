package com.lee.八大排序算法;

import java.util.Arrays;

//https://www.cnblogs.com/chengxiao/p/6129630.html
public class HeapSort {
    public static void main(String []args){
        int []arr = {9,8,7,6,10,4,10,2,1,10,12,21,12};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int i = arr.length/2 -1 ; i >=0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }
        for (int j = arr.length-1; j >0 ; j--) {
            swap(arr,0,j);
            adjustHeap(arr,0,j);
        }
    }

    private static void adjustHeap(int[] arr, int i, int length) {
        for (int k = i*2+1; k < length; k=k*2+1) {
            int tmp = arr[i];
            if (k+1 <length && arr[k+1]> arr[k]){
                k++;
            }
            if (arr[k] > arr[i]){
                arr[i] = arr[k];
                 i = k;
            }else {
                break;
            }
            arr[i] = tmp;
        }
    }
    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}


