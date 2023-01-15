package com.leecode.排序_数组;

//输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4

import java.util.HashMap;
import java.util.Map;

public class _704_二分查找 {
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = left + ((right -left)>>1);
            if (nums[mid] > target){
               right = mid;
            }else if  (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid+1;
            }
        }
        return  -1;
    }





    public int search(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        if (map.get(target)!=null){

            return map.get(target);
        }else {
            return  -1;
        }
    }
}
