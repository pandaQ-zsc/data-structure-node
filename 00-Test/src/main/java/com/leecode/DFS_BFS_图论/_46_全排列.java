package com.leecode.DFS_BFS_图论;


import java.util.ArrayList;
import java.util.List;

public class _46_全排列 {
    private List<List<Integer>> list;
    private int[] nums;
    private int[] result;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<>();
        if (nums.length == 0) return list;
        this.nums = nums;
        result = new int[nums.length];
        used = new boolean[nums.length];
        dfs(0);
        return list;

    }

    private void dfs(int idx) {
        if (idx == nums.length) {
            List<Integer> resultList = new ArrayList<>();
            for (int value : result){
                resultList.add(value);
            }
            list.add(resultList);
            return;
        }
        //枚举这一层可以做出的所有选择
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            result[idx] = nums[i];
            used[i] = true;
            dfs(idx + 1);
            used[i] = false;
        }
    }


}
