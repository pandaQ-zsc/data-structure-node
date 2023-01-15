package com.sort;

public class BubbleSort {
    public static int[] bubbleSort2(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
        return array;
    }

    //优化版
    static void bubbleSort(Integer[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            //sortedIndex主要是为了数组完全有序做准备的
            //sortedIndex的初始值默认设置为1时.在数组完全有序的时候，一轮扫描后end = 0就直接结束了
            int sortedIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                    //记录最后一次交换在哪里
                    sortedIndex = begin;
                }
            }
            //  end赋值后 ， 下一轮扫描就从 1到end  而不是数组的尾部

            end = sortedIndex;
        }
    }


}
