package com.lee.排序_数组;

public class _88_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         * 输入：nums1 = [1,2,3,0,0,0], m = 3,
         *      nums2 = [2,5,6], n = 3
         * 输出：[1,2,2,3,5,6]
         */
        int i1 = m - 1;
        int i2 = n - 1;
        int cur = nums1.length - 1;
        while (i2 >= 0) {
            if (i1 >= 0 && nums1[i1] > nums2[i2])
                nums1[cur--] = nums1[i1--];
            else  // nums2[i2] > nums[i1] 和i1<0  直接覆盖
                nums1[cur--] = nums2[i2--];
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        /**
         * 输入：nums1 = [9,10,11,0,0,0], m = 3,
         *      nums2 = [2,5,6], n = 3
         * 输出：[1,2,2,3,5,6]
         */
        int n1 = m - 1, n2 = n - 1, cur = nums1.length - 1;
         while(n2 >= 0){
//             if (nums2[n2] > nums1[n1]) nums1[cur--] = nums2[n2--];
//             else nums1[cur--] = nums1[n1--];
             if ( n1 >= 0 && nums1[n1] > nums2[n2]) nums1[cur--] = nums1[n1--];
             else  nums1[cur--] = nums2[n2--];
         }
    }
}
