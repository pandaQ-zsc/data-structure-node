package com.leecode.高频题;

import java.util.ArrayList;

public class _34_在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange1(int[] nums, int target) {
        int[] arr = new int[2];
        ArrayList list = new ArrayList();
        for (int i : nums) {
            list.add(i);
        }
        arr[0] = list.indexOf(target);
        arr[1] = list.lastIndexOf(target);
        return arr;
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 1 && nums[0]==target){
            return new int[]{0,0};
        }
        int i = 0;
        int j = nums.length-1;
        int[] location = new int []{-1,-1};
        while(i <= j){
            int mid = (i+j)/2;
            if(nums[mid] < target){
                i = mid+1;
            }
            else if(nums[mid] > target){
                j = mid-1;
            }
            else{
                //寻找起始位置和终点位置;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for(int k =i;k <= j;k++){
                    if(nums[k] == target){
                        min = Math.min(min,k);
                        max = Math.max(max,k);
                    }
                }
                location[0] = min;
                location[1] = max;
                break;
            }
        }

        return location;
    }


}
