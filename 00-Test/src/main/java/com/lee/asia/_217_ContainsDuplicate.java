package com.lee.asia;

import java.util.HashMap;

/**
 * @author: xiong.qiang
 * @date: 2023/5/10 17:19
 */
public class _217_ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i] , i);
            }else {
                return true;
            }
        }
        return false;
    }

    //Example 1:
    //Input: nums = [1,2,3,1]
    //Output: true
    public static void main(String[] args) {
        boolean res = containsDuplicate(new int[] {1,2,3,5});
        System.out.println(res);
    }
}
