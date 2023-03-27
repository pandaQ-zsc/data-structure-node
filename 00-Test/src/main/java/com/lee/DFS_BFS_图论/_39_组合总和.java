package com.lee.DFS_BFS_图论;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39_组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if ( candidates == null || candidates.length == 0  ) return null;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0,list, target,new ArrayList<>(),candidates);
        return list;
    }

    private void dfs(int idx, List<List<Integer>> list, int remain, List<Integer> nums, int[] candidates) {
        if (remain < 0 ){
            return;
        }
        if (remain == 0) {
            list.add(new ArrayList<>(nums));
            return;
        }
        for (int i = idx; i <candidates.length ; i++) {
            nums.add(candidates[i]);
            dfs(i,list,remain - candidates[i],nums,candidates);
            nums.remove(nums.size()-1);
        }
    }
}
