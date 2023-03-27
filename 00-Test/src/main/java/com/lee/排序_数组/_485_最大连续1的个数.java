package com.lee.排序_数组;

public class _485_最大连续1的个数 {
    //输入：[1,1,0,1,1,1]
    //输出：3
    //解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.

    public int findMaxConsecutiveOnes(int[] nums) {
     if (nums.length == 0) return 0;
     int max = 0;
     int count =0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                count ++;
            }else{
                max = Math.max(max,count);
                count = 0;
            }
        }
        max = Math.max(max,count);
        return max;
    }

//  if (nums.length == 0 ) return 0;
//        int max = 0 ;
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 1) {
//                count ++;
//            }else { // nums[i] == 0
//                max = Math.max(max,count);
//                count = 0;
//            }
//        }
//        max = Math.max(max,count);
//        return max;


    public int findMaxConsecutiveOnes2(int[] nums) {
        if (nums.length == 0 ) return 0;
        int max = 0 ;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count ++;
            }else { // nums[i] == 0
                    count = 0;
            }
            if (count > max){
                max = count;
            }
        }
        return max;
    }
}
