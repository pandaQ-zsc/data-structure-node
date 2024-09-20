package com.lee.asia;

import cn.hutool.core.util.ArrayUtil;
import com.lee.链表.ListNode;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: xiong.qiang
 * @date: 2023/5/17 17:48
 */
public class _378_KthSmallestElement {

    public static int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                queue.add(matrix[i][j]);
            }
        }
        for (int i = 0; i < k-1; i++) {
            System.out.println(queue.poll());
        }
        if (!queue.isEmpty()){
          res = queue.peek();
        }
        return res;
    }


    //Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
    //Output: 13
    //Explanation: The elements in the matrix are
    // [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,5,9},{10,11,13},{12,13,15}};
        kthSmallest(a,8);
        System.out.println("==================");
        for (int i = 0; i < 10; i++) {
            int b  = (int) (Math.random() * 10);
            System.out.println(b);
        }
        System.out.println("===================");
        Integer[] numbers = new Integer[]{1,3,4,6,7};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(numbers));
        System.out.println(ArrayUtil.toString(list));
        Collections.sort(list);




    }
}
