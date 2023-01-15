package com.mj;

import java.util.Scanner;
//3
//5 1
//0 1 0 1 0
//2

//7 1
//0 1 0 0 2 1 0
//2

//7 2
//0 1 0 0 2 1 0
//1
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int length = sc.nextInt();
            int index = sc.nextInt();
            int[] arr = new int[length];
            for (int j = 0; j < length; j++) {
                int item = sc.nextInt();
                arr[j] = item;
            }
            int count = creat(arr, index);
            System.out.println(count);
        }

    }

    static int creat(int[] arr, int index) {

        int countNum = 0;
//        int [] nums = new int[] {0,1,0,0,2,1,0};
        int[] nums = arr;
        int l = 0, r = nums.length - 1;
        for (int i = 1; i < nums.length; i++) {
//             nums(index-1)
            if (nums[i] <= nums[i - 1] || nums[i] <= nums[index - 1]) {
                continue;
            } else {
                countNum++;
            }
        }

        return countNum;
    }

}