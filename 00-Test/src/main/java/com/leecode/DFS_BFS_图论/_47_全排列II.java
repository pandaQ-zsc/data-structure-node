package com.leecode.DFS_BFS_图论;

import java.util.ArrayList;
import java.util.List;

public class _47_全排列II {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) return list;
        dfs(0, nums, list);
        return list;
    }

    private void dfs(int idx, int[] nums, List<List<Integer>> list) {
        if (idx == nums.length) {
            List<Integer> result = new ArrayList<>();
            for (int value : nums) {
                result.add(value);
            }
            list.add(result);
            return;
        }
        //枚举这一层可以做出的所有选择
        for (int i = idx; i < nums.length; i++) {
            //要保证一个数字在idx位置只会出现一次
            if (isRepeat(nums,idx,i)) continue;
            swap(nums, idx, i);
            dfs(idx + 1, nums, list);
            swap(nums, idx, i);
        }

    }

    private boolean isRepeat(int[] nums, int idx, int i) {
        for (int j = idx; j < i; j++) {
            if (nums[j] == nums[i]) return true;
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
