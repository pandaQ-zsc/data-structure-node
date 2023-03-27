package com.lee.DFS_BFS_图论;

public class _283_v1移动零 {
    //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，
    // 同时保持非零元素的相对顺序。
    //输入: [0,1,0,3,12]
    //输出: [1,3,12,0,0]
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0 ) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
               nums[j] = nums[i];
               if ( i != j){
                   nums[i]= 0;
               }
            }
            j++;
        }

    }

}
