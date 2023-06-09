package com.sort;

import java.time.OffsetDateTime;
import java.util.Arrays;

//https://leetcode-cn.com/problems/sort-an-array/solution/912-pai-xu-shu-zu-kuai-pai-zhi-shuang-bi-9z8h/
//https://www.cnblogs.com/chengxiao/p/6129630.html
public class HeapSort_test1 {
    public static void main(String[] args) {
        int i;
//        int[] a = { 20, 30, 90, 40, 70,110,60,10,100,50,80};
//        int[] a = {40, 20, 30, 10, 60, 50};
//        int a[] = {30, 40, 60, 10, 20, 50};
//	      int a[] = {10,20,30,40,50,60};
        int a[] = {60,50,40,30,20,10};
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
            arr[c] = tmp ;

        }
    }






    // 交互数值
//因为在这段代码中，a ^= b; 表示将变量 a 和 b 进行异或运算，并将结果赋值给 a；
// b ^= a; 表示将变量 b 和 a 进行异或运算，并将结果赋值给 b；
// a ^= b; 表示将变量 a 和 b 进行异或运算，并将结果赋值给 a。这三条语句相当于执行了以下操作：
//将 a 和 b 的值进行异或运算，得到的结果赋值给 a。
//将 a（此时 a^b） 和 b 的新值进行异或运算，得到的结果赋值给 b，此时 b 的值已经是原来的 a 的值 (异或两次)。 a^b^a = b ;   相同为0 ，不同为1   10^10 = 00  00^10 = 10;
//将 a （此时 a^b） 和 b (此时是 a) 的新值进行异或运算，得到的结果赋值给 a，此时 a 的值已经是原来的 b 的值。 a^b^a = a;
    private static void swap (int[] a,int i, int j){
        a[i] ^= a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];

    }

}


