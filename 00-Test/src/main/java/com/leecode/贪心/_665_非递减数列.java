package com.leecode.贪心;

public class _665_非递减数列 {
    //输入: nums = [4,2,3]
    //输出: true
    //解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
    //----------------------
    //题目说该代码没有通过测试用例 [3,4,2,3]
    //---------------------//    例①： 4, 2, 5
//    例②： 1, 4, 2, 5
//    例③： 3, 4, 2, 5
    //这题看分析那么一大截，其实只是当发现有下降的时候，
    // 多判断了一次 nums[i] 和 nums[i - 2]，本身没那么难。

    public boolean checkPossibility(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (i == 1 || nums[i] >= nums[i - 2]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
                if (count == 0)
                    return false;
                count--;
            }
        }
        return true;
    }
}

