package com.lee.asia;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _169_多数元素 {
    //给定一个大小为 n 的数组，找到其中的多数元素。
    //多数元素是指在数组中出现次数 大于[n/2]的元素。
    //你可以假设数组是非空的，并且给定的数组总是存在多数元素。
    public int majorityElement(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() > nums.length >> 1) {
                res = entry.getKey();
            }
        }

        return res;
    }

    public int majorityElement2(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max){
                //这里是获取键。不是值
                max = entry.getKey();
            }

        }

        return max;
    }
    //示例 1：
    //
    //输入：nums = [3,2,3]
    //输出：3
    //示例 2：
    //
    //输入：nums = [2,2,1,1,1,2,2]
    //输出：2
    public static void main(String[] args) {

    }
}
