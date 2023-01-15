package com.mj;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        int index = 1;
        int countNum = 0;
        int [] nums = new int[] {0,1,0,1,0};
        int l = 0, r = nums.length - 1;
        for (int i = 1; i < nums.length; i++) {
//             nums(index-1)
            if (nums[i] <= nums[i - 1] || nums[i] <= nums[index - 1]) {
                continue;
            } else {
                countNum++;
            }
        }
        System.out.println(countNum);
    }

}