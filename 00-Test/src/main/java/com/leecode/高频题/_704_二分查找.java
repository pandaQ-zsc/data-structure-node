package com.leecode.高频题;

//输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
public class _704_二分查找 {

    //左闭右开  不存在l = r的情况
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                //区别在此
                r = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //左闭右闭  存在 l = r 的情况
    public int search2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int search3(int[] nums, int target) {
        int l = 0;
        //右边是开区间 
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                //右边是开区间 : r = mid  相当左闭右闭的r= mid -1
                r = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int search4(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}