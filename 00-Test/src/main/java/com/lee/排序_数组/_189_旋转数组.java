package com.lee.排序_数组;
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]   1 --  nums[1]  右旋转 1 步:
//向右旋转 2 步: [6,7,1,2,3,4,5]   1 --  nums[2]  右旋转 2 步:
//向右旋转 3 步: [5,6,7,1,2,3,4]   1 --  nums[3]  右旋转 3 步:
public class _189_旋转数组 {
    //不需要使用额外空间  -- 分治

    //首先对整个数组实行翻转，这样子原数组中需要翻转的子数组，就会跑到数组最前面。
    //这时候，从 k处分隔数组，左右两数组，各自进行翻转即可。
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length-1); // [0,nums.length-1]
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    private void reverse(int[] nums, int l, int r) {
        while(l < r ){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }


    //需要使用额外空间
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        int [] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[(i + k) % n]  = nums[i];
        }
        System.arraycopy(newArr, 0, nums,0, n);
    }




}
