package com.leecode.DFS_BFS_图论;

public class _283_移动零 {
    public void moveZeroes(int[] nums) {
        if (nums == null) return;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[cur];
                nums[cur] = tmp;
                cur++;
            }
        }

    }
}
