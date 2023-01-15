package com.leecode.高频题;

//输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
public class _704_二分查找 {

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (target == nums[l]) {
            return l;
        }
        return -1;
    }

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
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}