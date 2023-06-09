package com.lee.asia;

/**
 * @author: xiong.qiang
 * @date: 2023/5/17 17:09
 */
public class _485_MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int l = 0 ,r = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                r++;
                count = Math.max(r-l,count);
            }else {
                l=i;
                r=i;
            }
        }
        return count;
    }

    //Input: nums = [1,1,0,1,1,1]
    //Output: 3
    //Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
    //
    public static void main(String[] args) {


    }
}
