package com.sort;

import java.util.Arrays;

//https://leetcode-cn.com/problems/sort-an-array/solution/912-pai-xu-shu-zu-kuai-pai-zhi-shuang-bi-9z8h/
//https://www.cnblogs.com/chengxiao/p/6129630.html
public class HeapSort_test {
    public static void main(String[] args) {
        int i;
        int[] a = { 20, 30, 90, 40, 70,110,60,10,100,50,80};
//        int[] a = {40, 20, 30, 10, 60, 50};
//        int a[] = {30, 40, 60, 10, 20, 50};
//	      int a[] = {10,20,30,40,50,60};
        System.out.print("before sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.print("\n");

        heapSort(a);
//        bubbleSort1(a, a.length);
        //bubbleSort2(a, a.length);

        System.out.print("after  sort:");
        String arrString = Arrays.toString(a);
        System.out.println(arrString);
    }

    private static void heapSort(int[] arr) {
        for(int c = arr.length/2 -1 ;c >= 0 ; c--){
            heapDown(arr, c, arr.length);
        }

        for(int i = arr.length -1 ; i > 0; i--){
            swap(arr,0,i);
            heapDown(arr,0,i);
        }

    }

    private static void heapDown(int[] arr, int c, int len) {
        for (int l = c*2 +1 ;l < len ; l = l*2 + 1){
            int tmp = arr[c];
            if (l + 1 < len && arr[l]< arr[l+1]){
                l++;
            }
            if (arr[l] > arr[c]){
                arr[c] = arr[l];
                c = l;
            }else {
                break;
            }
            arr[c] = tmp;
        }
    }

    private static void swap (int[] a,int i, int j){
        a[i] ^= a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];
    }

}


