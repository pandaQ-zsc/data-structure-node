package com.leecode.高频题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_三数之和 {
    //    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (nums.length < 3) return res;
//        Arrays.sort(nums);
//        // i  用来扫描三元组的第一个元素
////        int lastIdx = nums.length - 3;
//        int lastR = nums.length - 1;
//        for (int i = 0; i < lastR; i++) {
//            if (i > 0 && nums[i] == nums[i - 1]) continue;
//            int l = i + 1, r = lastR, remain = -nums[i];
//            while (l < r) {
//                int sumLr = nums[l] + nums[r];
//                if (sumLr == remain) {
//                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
//                    //跳过相同的值
//                    while (l < r && nums[l] == nums[l + 1]) l++;
//                    while (l < r && nums[r] == nums[r - 1]) r--;
//                    // 往中间逼近
//                    l++;
//                    r--;
//                } else if (sumLr < remain) {
//                    l++;
//                } else {
//                    r--;
//                }
//            }
//
//        }
//        return res;
//    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list= new ArrayList<>();
        if ( nums == null || nums.length == 0) return  list;
        Arrays.sort(nums);
        // -4 -1 -1 0 1 2
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1,r = nums.length -1, remain = -nums[i];
            if ( i > 0 && nums[i] == nums[i-1])continue;
            while(l < r ){
                int sumLr = nums[l] + nums[r];
                if (sumLr == remain){
                    list.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while ( l < r && nums[l] == nums[l+1]) l++;
                    while(l < r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }else if (sumLr < remain){
                    l++;
                }else {
                    r--;
                }
            }

        }

        return list;
    }
}
