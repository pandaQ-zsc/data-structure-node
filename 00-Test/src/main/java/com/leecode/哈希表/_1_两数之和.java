package com.leecode.哈希表;

import java.util.HashMap;
import java.util.Map;

//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
public class _1_两数之和 {
    public static int[] twoSum(int[] nums, int target) {
        if (nums== null) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer idx = map.get(target - nums[i]);
            if (idx != null){
                return new int[]{idx,i};
            }
            map.put(nums[i],i);
        }
        return null;

    }

//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i],i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            Integer idx = map.get(target - nums[i]);
//            if (idx!= null) {
//                if (idx == i) continue;
//                return new int[]{i,idx};
//            }
//        }
//        return null;
//    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{15,11,7,3}, 10);
        for (int a:ints){
            System.out.print(a+"_");
        }
    }
}
