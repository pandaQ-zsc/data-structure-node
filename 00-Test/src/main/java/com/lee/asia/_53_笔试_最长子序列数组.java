package com.lee.asia;

import java.util.Arrays;

//https://blog.csdn.net/anlian523/article/details/105421611
public class _53_笔试_最长子序列数组 {
    public static void main(String[] args) {
        //4,-1,2,1
//        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = new int[]{1, 2};
//        if (nums.length==1){
//            return ;
//        }

        int maxNums = nums[0], start = 0, end = 0, finalStart = 0, finalEnd = 0;
        int maxIdx = 0;
        int maxdp = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            //6
            maxdp = Math.max(maxdp, dp[i]);
        }
        String s1 = Arrays.toString(dp);
        System.out.println(s1);
        for (int i = 0; i < dp.length; i++) {
            if (maxdp == dp[i]) {
                maxIdx = i;
                break;
            }
        }
        finalEnd = maxIdx;
        for (int i = maxIdx; i >= 0; i--) {
            if (nums[i] == dp[i]) {
                finalStart = i;
                break;
            }
        }
//        for (int i = 1; i < nums.length; i++) {
//
//            if (nums[i-1] > 0){
//                nums[i]+= nums[i-1];
//                end = i;
//            }else {
//                start = end = i;
//            }
//            if (nums[i] > maxNums){
//                finalStart = start;
//                finalEnd = end;
//            }
//            maxNums = Math.max(maxNums,nums[i]);
//        }
        String t = Arrays.toString(nums);
        System.out.println(t);
        System.out.println(maxNums);
        System.out.println(finalStart);
        System.out.println(finalEnd);
        int[] res = Arrays.copyOfRange(nums, finalStart, finalEnd + 1);
        String s = Arrays.toString(res);
        System.out.println(s);

    }

}
