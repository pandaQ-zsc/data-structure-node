package com.lee.八大排序算法;

public class SelectionSort {
    //相比于冒泡排序，比较次数少 ，因此整体性能比冒泡排序强
    static void selectionSort1(int [] array){
        for (int end = array.length-1; end >0 ; end--) {
            int max = array[0];
            for (int begin = 0; begin <= end; begin++) {
                 if (array[max] < array[begin])  max = array[begin];
            }
            int tmp = array[max];
            array[max] = array[end];
            array[end] = tmp;
        }
    }
}
