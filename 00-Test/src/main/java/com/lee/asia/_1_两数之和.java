package com.lee.asia;


import java.util.HashMap;
import java.util.Map;

public class _1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        // nums,idx
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer idx = map.get(target - nums[i]);
            if (idx != null) {
                return new int[]{idx, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
