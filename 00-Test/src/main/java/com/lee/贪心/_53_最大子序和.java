package com.lee.贪心;

public class _53_最大子序和 {
    public int maxSubArray(int[] nums) {
       int res = nums[0];
       int sum = 0;
       for(int num : nums){
           if (sum > 0){
               sum = sum + num;
           }else {
               sum = num;
           }
           res = Math.max(res,sum);
       }
       return res;
    }

    public int maxSubArray2(int[] nums) {
       int pre = 0;
       int maxRes = nums[0];
       for(int num : nums){
           pre = Math.max(num , pre + num);
           maxRes = Math.max(maxRes,pre);
       }
       return maxRes;
    }

}
