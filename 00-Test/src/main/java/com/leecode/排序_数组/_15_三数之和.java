package com.leecode.排序_数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode-cn.com/problems/3sum/solution/shuang-zhi-zhen-by-linniu-nukj/
//  -1 -1 2 4 7
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]


//-1 -1 1 0
public class _15_三数之和 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length <3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0) break;
            if (i>0 && nums[i] == nums[i-1])continue;
            int l = i+1, r=nums.length-1;
            int sum = -nums[i];
            while(l < r){
                if (nums[l] + nums[r] == sum){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l<r && nums[l] == nums[l+1]) l++;
                    while(l<r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }else if (nums[l]+nums[r]<sum){
                    l++;
                }else {
                    r--;
                }
            }
        }
        return res;
    }
////  -1 -1 2 2 2 4 7
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int tmp = -nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == tmp) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < tmp) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        threeSum(new int[]{1,-1,-1,0});
    }
}
