package com.lee.八大排序算法;

/**
 * 快速排序
 */
public class QuickSort2 {
    public static void main(String[] args) {
//        int[] arrays = new int[]{1, 2, 5, 2, 1, 7, 10, 21, 1, 3, 5, 21, 44};
                int[] arrays = new int[]{10,9,8,7,6,5,4,3,2,1};
        sort(0, arrays.length, arrays);
        for (int j = 0; j < arrays.length; j++) {
            System.out.print("_" + arrays[j] + "_");

        }
    }

    private static void sort(int begin, int end, int[] arrays) {
        if (end-begin < 2) return;
        int mid = pivot(begin,end,arrays);
        sort(begin,mid,arrays);
        sort(mid+1,end,arrays);
    }

    private static int pivot(int begin, int end, int[] arrays) {
        end--;
        swap(begin,begin + (int) Math.random()*(end-begin),arrays);
        int pivot = arrays[begin];
        while(begin < end){
            while(begin < end){
                if (arrays[end] > pivot){
                    end--;
                }else {
                    arrays[begin++] = arrays[end];
                    break;
                }
            }
            while (begin < end){
                if (arrays[begin] < pivot){
                    begin++;
                }else {
                    arrays[end--] = arrays[begin];
                    break;
                }
            }
        }
        arrays[begin] = pivot;
        return begin;
    }

    /**
     * 对 [begin, end) 范围的元素进行快速排序
     */


    public static void swap(int i, int j, int[] arrays) {
        int tmp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = tmp;
    }

}
