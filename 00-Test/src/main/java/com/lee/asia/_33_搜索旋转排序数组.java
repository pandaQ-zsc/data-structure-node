package com.lee.asia;


//https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-bai-liao-9983de-javayong-hu-by-reedfan/
public class _33_搜索旋转排序数组 {
    //整数数组 nums 按升序排列，数组中的值 互不相同 。
    //
    //在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
    //
    //示例 1：
    //
    //输入：nums = [4,5,6,7,0,1,2], target = 0
    //输出：4
    //示例2：
    //
    //输入：nums = [4,5,6,7,0,1,2], target = 3
    //输出：-1
    //
    //
    //   思路： 【无限分割永远都在有序的序列里面找。】
    //有序的部分用二分法查找，无序的部分继续一分为二，最后无序的部分会只剩下一个数。

    //思路：如果中间的数小于最右边的数，则右半段是有序的，
    // 若中间数大于最右边数，则左半段是有序的，
    // 我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，
    // 这样就可以确定保留哪半边了
    //  2 3 4 |5| 6 7 1
    //  6 7 1 |2| 3 4 5
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序
            //为什么是小于等于。其实就是为了最后只剩两个数的时候
            if (nums[left] <= nums[mid]) {
                //target在前半部分
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                    //target在后半部分
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;
            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
