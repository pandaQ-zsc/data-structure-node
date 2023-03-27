package com.lee.DFS_BFS_图论;


import java.util.ArrayList;
import java.util.List;

public class _46_全排列2 {
    private List<List<Integer>> list;
    private int[] nums;
    private List<Integer> result;

    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<>();
        if (nums.length == 0) return list;
        this.nums = nums;
        result = new ArrayList<>();
        dfs(0);
        return list;
    }

    private void dfs(int idx) {
        if (idx == nums.length) {
            list.add(new ArrayList<>(result));
        }
        //枚举这一层可以做出的所有选择
        for (int num : nums) {
            if (result.contains(num)) continue;
            result.add(num);
            dfs(idx + 1);
            result.remove(result.size()-1);
        }
    }


}
