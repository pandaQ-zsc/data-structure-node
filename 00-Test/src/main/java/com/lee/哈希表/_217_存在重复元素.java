package com.lee.哈希表;

import java.util.*;

public class _217_存在重复元素 {
    //输入: [1,2,3,1]
    //输出: true
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) return true;
        }
        return false;
    }
}
