package com.sort;

/**
 * @author: xiong.qiang
 * @date: 2023/4/10 15:45
 */

//直接插入排序(Straight Insertion Sort)的基本思想是：把n个待排序的元素看成为一个有序表和一个无序表。
// 开始时有序表中只包含1个元素，无序表中包含有n-1个元素，排序过程中每次从无序表中取出第一个元素，
// 将它插入到有序表中的适当位置，使之成为新的有序表，重复n-1次可完成排序过程。
public class InsertSort {

    /*
     * 直接插入排序
     *
     * 参数说明：
     *     a -- 待排序的数组
     *     n -- 数组的长度
     */

    //简化版本 GPT
    //循环从第二个元素开始，到最后一个元素为止。对于每个元素，我们将其保存在 key 中，
    // 然后从当前元素向前遍历已排序的元素，如果遇到一个元素比 key 大，就将该元素后移一位，
    // 继续向前遍历，直到遇到一个元素不大于 key 为止。然后将 key 插入到这个位置上。
    public  static void insertSort(int[] arr) {
        int n = arr.length;
        for (int i =1; i <n; i++) {
            int j = i-1;
            int tmp = arr[i];
            while( j>=0 && arr[j] >tmp){
                arr[j+1] =arr[j];
                j--;
            }
            arr[j+1] = tmp;

        }
    }
    // practice
    public  static void insertSort_test(int[] arr) {
        int n = arr.length;
        for(int i = 1 ; i < n ; i++){
            int j = i-1;
            int tmp = arr[i];
            while(j >= 0 && arr[j+1] > tmp ){
                arr[j +1 ] = arr[j];
                j--;
            }
            arr[j+1] = tmp;
        }
    }



    public  static void insertSort_sky(int a[], int n) {
        int i, j, k;
        for (i = 1; i < n; i++) {
            //为a[i]在前面的a[0...i-1]有序区间中找一个合适的位置
            for (j = i - 1; j >= 0; j--) {
                if (a[j] < a[i]) {
                    break;
                }
            }

            //如找到了一个合适的位置
            if (j != i - 1) {
                //将比a[i]大的数据向后移
                int temp = a[i];
                for (k = i - 1; k > j; k--) {
                    a[k + 1] = a[k];
                }
                //将a[i]放到正确位置上
                a[k + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int i;
//        int[] a = {40, 20, 30, 10, 60, 50};
        int[] a = {20, 20, 20, 20, 20, 20};
//        int a[] = {30, 40, 60, 10, 20, 50};
//        int a[] = {10,20,30,40,50,60};
        System.out.print("before sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.print("\n");

        insertSort(a);
//        bubbleSort1(a, a.length);
        //bubbleSort2(a, a.length);

        System.out.print("after  sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");

    }
}
