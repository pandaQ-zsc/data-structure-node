package com.lee.DFS_BFS_图论;


import java.util.ArrayList;
import java.util.List;

public class _46_测试_全排列 {
    private int[] result;
    private int[] nums;
    private boolean[] used;
    private List<List<Integer>> list;
    public List<List<Integer>> permute(int[] nums) {
       if (nums.length == 0) return  list;
       list = new ArrayList<>();
       this.nums = nums;
       result = new int[nums.length];
       used = new boolean[nums.length];
       dfs(0);
       return  list;
    }

    private void dfs(int idx) {
       if (idx == nums.length){
           List<Integer> resultList = new ArrayList<>();
           for (int value : result){
               resultList.add(value);
           }
           list.add(resultList);
           return;
       }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            result[idx] = nums[i];
            dfs(idx+1);
            used[i] = false;

        }
    }
}
