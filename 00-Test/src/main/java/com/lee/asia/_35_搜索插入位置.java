package com.lee.asia;

//给定一个排序数组和一个目标值，在数组中找到目标值，
//并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//你可以假设数组中无重复元素。

//输入: [1,3,5,6], 5
//输出: 2
//示例 2:
//
//输入: [1,3,5,6], 2
//输出: 1


//https://leetcode.cn/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
public class _35_搜索插入位置 {
    public static void main(String[] args) {
        int i = searchInsert2(new int[]{1, 3, 5, 6, 7, 9}, 11);
        System.out.println(i);
    }

    public static int searchInsert2(int[] arr, int target) {
        if (target > arr[arr.length - 1]) {
            return arr.length;
        }
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        return l;
    }

    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        // 特殊判断
        if (nums[len - 1] < target) {
            return len;
        }
        String s = "ni shi ni ";
        char c = s.charAt(3);


        // 程序走到这里一定有 nums[len - 1] >= target，插入位置在区间 [0..len - 1]
        int left = 0;
        int right = len - 1;
        // 在区间 nums[left..right] 里查找第 1 个大于等于 target 的元素的下标
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 下一轮搜索的区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是 [left..mid]
                right = mid;
            }
        }
        return left;
    }
}
