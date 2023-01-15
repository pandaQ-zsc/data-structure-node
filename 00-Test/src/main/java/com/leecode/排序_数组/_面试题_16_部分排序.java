package com.leecode.排序_数组;


public class _面试题_16_部分排序 {
    /**
     * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
     * 输出： [3,9]
     */
    public int[] subSort(int[] array) {
        if(array.length == 0) return new int[] {-1,-1};
        int max = array[0];
        int r = -1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= max){
                max = array[i];
            }else {
                r = i;
            }
        }
        //提前结束
        if (r == -1) return new int[] {-1, -1};

        int min = array[array.length-1];
        int l = -1;
        for (int i = array.length-2; i >= 0; i--) {
            if (array[i] <= min){
                min= array[i];
            }else {
                l = i;
            }
        }
        return new int[] {l,r};
    }
}
