package com.sort;

import java.util.Arrays;

//https://leetcode-cn.com/problems/sort-an-array/solution/912-pai-xu-shu-zu-kuai-pai-zhi-shuang-bi-9z8h/
//https://www.cnblogs.com/skywang12345/p/3602162.html
//堆分为"最大堆"和"最小堆"。最大堆通常被用来进行"升序"排序，而最小堆通常被用来进行"降序"排序。
//鉴于最大堆和最小堆是对称关系，理解其中一种即可。本文将对最大堆实现的升序排序进行详细说明。
//最大堆进行升序排序的基本思想：
//① 初始化堆：将数列a[1...n]构造成最大堆。
//② 交换数据：将a[1]和a[n]交换，使a[n]是a[1...n]中的最大值；然后将a[1...n-1]重新调整为最大堆。
// 接着，将a[1]和a[n-1]交换，使a[n-1]是a[1...n-1]中的最大值；然后将a[1...n-2]重新调整为最大值。 依次类推，直到整个数列都是有序的。
public class HeapSort {
    public static void main(String[] args) {
//        int[] arr = {3, 2, 1, 5, 6, 4};
//        int[] arr = {1, 2, 3,4, 5, 6};
        int[] arr = {20,30,90,40,70,110,60,10,100,50,80};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        //1.构建大顶堆   数组{20,30,90,40,70,110,60,10,100,50,80}转换为最大堆{110,100,90,40,80,20,60,10,30,50,70}的步骤。
        //  n/2 -1 来源：  因为堆是完全二叉树 叶子节点的数量最多只有满二叉树的一半，也就是说，非叶子节点的数量至少有一半。
        //  因此，我们可以从倒数第二层的最后一个节点开始，一直调整到根节点，这样就可以保证所有的非叶子节点都被正确调整了
        //arr.length / 2 - 1 表示倒数第二层的最后一个非叶子节点的索引位置。我们从这个节点开始向上逐层调整，直到根节点为止，
        // 就可以将原始数组转换为一个最大堆或最小堆。

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构 【因为只有从第一个非叶子节点开始才有--左、右叶子节点--才可以做调整】
            //调整:选择一个左右子节点中较大的进行交换   这样调整后 【每个堆都是最大堆】，
            //max_heap_down
            adjustHeap(arr, i, arr.length);
        }
        //【但此时还不是有序数组】  所以下面进行交换
        //2.调整堆结构+交换堆顶元素与末尾元素： 从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
        // ----> 遍历慢慢扩大有序范围【(len-2, len-1)-- (len-3,len-1) 有序 】
        for (int j = arr.length - 1; j > 0; j--) {
            //通过下面两步结合
            //  1.【确定arr[len-1]是有序(最大的)）】
            //  2. 将数组长度缩小成arr.length-1
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);//重新对堆进行调整
        }

    }

    /**
     *
     * Alia Name : max_heap_down
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * debug ref :<a href="https://www.cnblogs.com/skywang12345/p/3602162.html">数据对照debug</a>
     * @param arr : array obj
     * @param c : current index
     * @param length array.length
     *
     *
     */
    public static void adjustHeap(int[] arr, int c, int length) {
//            int temp = arr[c];//先取出当前元素i
            //l：左孩子索引
            for (int l = c * 2 + 1; l < length; l = l * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
                int temp = arr[c];//先取出当前元素i
                if (l + 1 < length && arr[l] < arr[l + 1]) {//如果左子结点小于右子结点，k指向右子结点
                    l++;
                }
                if (arr[l] > arr[c]) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
    //               【answer1】  swap(arr, c, l);
                    arr[c] = arr[l];
                    c = l;
                } else {
                    break;
                }
                arr[c] = temp;//将temp值放到最终的位置
            }
//       【answer1】  arr[c] = temp;//将temp值放到最终的位置

    }

    /**
     * 交换元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}


