package com.leecode.排序_数组;

public class _88_test_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         * 输入：nums1 = [1,2,3,0,0,0], m = 3,
         *      nums2 = [2,5,6], n = 3
         * 输出：[1,2,2,3,5,6]
         */
         int n1 = m -1 ;
         int n2 = n -1 ;
         int cur  = nums1.length - 1 ;
         while(n2>=0){
            if (n1 >= 0 && nums1[n1] >=nums2[n2])
                nums1[cur--] = nums1[n1--];
            else
                nums1[cur--] = nums2[n2--];
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
