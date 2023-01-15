package com.leecode.排序_数组;

public class _209_长度最小的子数组 {

    // [2,3,1,2,4,3]
    public static int minSubArrayLen2(int target, int[] nums) {
      int l = 0, r = 0 , sum = 0 ;
      int min = Integer.MAX_VALUE;
      while(r < nums.length){
          sum += nums[r++];
          while (sum >= target){
              min = Math.min(min,r-l);
              sum -= nums[l++];
          }
      }
      return min == Integer.MAX_VALUE ? 0 : min;
    }




    //   暴力法...
    public static int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= target) return  1;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target){
                    min  = Math.min(min,j-i+1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min ;
    }

    public static void main(String[] args) {
        int i = minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(i);
    }

}
