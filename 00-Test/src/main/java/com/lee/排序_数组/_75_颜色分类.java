package com.lee.排序_数组;

//https://leetcode-cn.com/problems/sort-colors/
public class _75_颜色分类 {
    /**
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     * <p>
     * 你可以不使用代码库中的排序函数来解决这道题吗？
     * 你能想出一个仅使用常数空间的一趟扫描算法吗
     * 空间复杂度 O（1） 时间复杂度 O（n）
     */
    public void sortColors(int[] nums) {
        int i = 0;
        int l = 0;
        int r = nums.length - 1;
        while (i <= r) {
            int val = nums[i];
            if (val == 0) {
                swap(nums, l++, i++);
            } else if (val == 1) {
                i++;
            } else {
                swap(nums, i, r--);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
