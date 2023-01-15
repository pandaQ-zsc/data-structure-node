package com.leecode.高频题;

public class _88_合并两个有序数组 {
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        /**
         * 输入：nums1 = [1,2,3,0,0,0], m = 3,
         *      nums2 = [2,5,6], n = 3
         * 输出：[1,2,2,3,5,6]
         */
        int i1 = m-1;
        int i2 = n-1;
        int cur= nums1.length-1;
        while(i2>= 0){
            if (i1>=0 && nums1[i1] > nums2[i2] ){
                nums1[cur--] = nums1[i1--];
            }else {
                nums1[cur--] = nums2[i2--];
            }
        }
    }
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m-1;
        int i2 = n-1;
        int cur = nums1.length-1;
        while (i2>=0){
            if (i1>=0&&nums1[i1]>nums2[i2]){
                nums1[cur--] = nums1[i1--];
            }else {
                nums1[cur--] = nums2[i2--];
            }
        }

    }


        public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1=0, i2=0;
        int [] tmp  = new int[nums1.length];
        int cur = 0;
        while (i1 < m && i2<n){
            if (nums1[i1] < nums2[i2]){
                tmp[cur++] = nums1[i1++];
            }else {
                tmp[cur++] = nums2[i2++];
            }
        }
        while(i1 < m){
            tmp[cur++] = nums1[i1++];
        }
        while (i2<n){
            tmp[cur++] = nums2[i2++];
        }
        for (int i = 0; i < tmp.length; i++) {
            nums1[i] = tmp[i];
        }
    }

}
