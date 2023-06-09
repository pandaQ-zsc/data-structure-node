package com.sort;

/**
 * @author: xiong.qiang
 * @date: 2023/4/11 10:09
 */
public class SelectSort {
    //相比于冒泡排序，比较次数少 ，因此整体性能比冒泡排序强
    static void selectionSort(int [] nums){
        int min;
        for (int i = 0; i < nums.length; i++) {
            min = i;
            for (int j = i+1; j <nums.length ; j++) {
                if (nums[min] > nums[j]){
                    min = j;
                }
            }
            if (min != i){
                int tmp = nums[min];
                nums[min] = nums[i];
                nums[i]  = tmp;
            }
        }

    }
    static void selectionSort_test(int [] nums) {
        for (int i = 0; i < nums.length; i++) {
            int  m = i;
            for (int j = i+1; j <nums.length ; j++) {
                if (nums[j] < nums[m]){
                    m = j;
                }
            }
            if (m!= i){
                int tmp = nums[m];
                nums[m] = nums[i];
                nums[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int i;
//        int a[] = {60,50,40,30,20,10};
        int a[] = {30, 40, 60, 10, 20, 50};
//	int a[] = {10,20,30,40,50,60};


        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");

        selectionSort_test(a);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");
    }
}
