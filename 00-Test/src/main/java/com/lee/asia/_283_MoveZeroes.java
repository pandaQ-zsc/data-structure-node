package com.lee.asia;

import java.util.Arrays;

/**
 * @author: xiong.qiang
 * @date: 2023/5/11 17:38
 */
public class _283_MoveZeroes {
    public static void moveZeroes(int[] nums) {
        if (nums.length ==1){
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        while(index < nums.length ){
            nums[index++] = 0;
        }

    }
    public static void moveZeroes1(int[] nums) {
        int index = 0;
        for(int num : nums){
            if (num != 0){
                nums[index++]  = num;
            }
        }
        while(index < nums.length){
            nums[index++] = 0;
        }

    }



    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
//        int[] nums = new int[]{1,0,1};
//        int[] nums = new int[]{2,1};
        moveZeroes1(nums);
        System.out.println(Arrays.toString(nums));
    }
}
