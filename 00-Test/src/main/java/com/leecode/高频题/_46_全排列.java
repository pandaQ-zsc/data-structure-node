package com.leecode.高频题;

import java.util.ArrayList;
import java.util.List;

public class _46_全排列 {
    //输入：nums = [1,2,3]
    //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    List<List<Integer>> res;
    List<Integer> list;
    boolean[] flag;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        flag = new boolean[nums.length];
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                list.add(nums[i]);
                flag[i] = true;
                dfs(nums);
                flag[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

}
