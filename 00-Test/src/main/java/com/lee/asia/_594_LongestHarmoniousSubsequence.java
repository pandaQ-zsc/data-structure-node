package com.lee.asia;


import java.util.HashMap;
import java.util.Map;

/**
 * @author: xiong.qiang
 * @date: 2023/5/12 10:41
 */
public class _594_LongestHarmoniousSubsequence {
    //error   System.out.println(findLHS(new int[]{1,2,1,3,0,0,2,2,1,3,3}));
    public static int findLHS1(int[] nums) {
        int res = Integer.MIN_VALUE;
        int same =1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]){
                same++;
            }
        }
        if (same == nums.length) return 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] - nums[i]==1 || nums[j] - nums[i] == -1 || nums[j] - nums[i] ==0){
                    count++;
                }
                res = Math.max( res , count);
            }
        }
        return res == 1 ? 0 : res;

    }
    public static int findLHS(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for (Integer num : map.keySet()) {
            if (map.containsKey(num + 1)){
                count  = Math.max(count, map.get(num)+map.get(num+1));
            }
        }
        return count;

    }

    //Input: nums = [1,3,2,2,5,2,3,7]
    //Output: 5
    //Explanation: The longest harmonious subsequence is [3,2,2,2,3].
    //

    //Input: nums = [1,1,1,1]
    //Output: 0
    public static void main(String[] args) {
//        System.out.println(findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
//        System.out.println(findLHS(new int[]{1,2,2,1}));
//        System.out.println(findLHS(new int[]{1,3,5,7,9}));
        System.out.println(findLHS(new int[]{1,2,1,3,0,0,2,2,1,3,3}));

    }
}
