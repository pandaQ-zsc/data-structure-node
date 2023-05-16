package com.sort;


import java.util.Arrays;

/**
 *
 * 【希尔排序的时间复杂度为 O(n log n)】
 */
public class ShellSort {
    public static void main(String []args){
//        int []arr ={1,2,3,4,5,6,7,8,9};
//        sort(arr);
//        System.out.println(Arrays.toString(arr));
        int []arr1 ={80,30,60,40,20,10,50,70};
//        sort1(arr1);
        sort_test(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void sort_test(int []arr){
        for (int gap = arr.length/2 ; gap >0;gap/=2){
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while(j -gap >=0 && arr[j] < arr[j-gap]){
                    swap(arr,j,j-gap);
                    j-=gap;
                }
            }
        }
    }


    /**
     * 希尔排序 针对有序序列在插入时采用交换法
     * @param arr
     */
    public static void sort(int []arr){
        //增量gap，并逐步缩小增量
        //gap=4 :意味着数列分为4个组
        for(int gap=arr.length/2;gap>0;gap/=2){
            //共gap个组，对每一组都执行直接插入排序
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i=gap;i<arr.length;i++){
                int j = i;
                while(j-gap>=0 && arr[j]<arr[j-gap]){
                    //插入排序采用交换法
                    swap(arr,j,j-gap);
                    j-=gap;
                }
            }
        }
    }

    /**
     * 希尔排序 针对有序序列在插入时采用移动法。
     * @param arr
     */
    public static void sort1(int []arr){
        //增量gap，并逐步缩小增量
        for(int gap=arr.length/2;gap>0;gap/=2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i=gap;i<arr.length;i++){
                int j = i;
                int temp = arr[j];
                if(arr[j]<arr[j-gap]){
                    while(j-gap>=0 && temp<arr[j-gap]){
                        //移动法
                        arr[j] = arr[j-gap];
                        j-=gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
    /**
     * 交换数组元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }
}