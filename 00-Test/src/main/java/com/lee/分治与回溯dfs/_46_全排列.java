package com.lee.分治与回溯dfs;

import java.util.ArrayList;
import java.util.List;

public class _46_全排列 {
    //给定一个 没有重复 数字的序列，返回其所有可能的全排列。
    //示例: 输入: [1,2,3] 输出: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
   List<List<Integer>> res;
    List<Integer> list;
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        used = new boolean[nums.length];
        if (nums.length == 0 ) return res;
        dfs(nums);
        return  res;
    }
    private void dfs(int [] nums){
        if (nums.length == list.size()){
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            list.add(nums[i]);
            used[i] = true;
            dfs(nums);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }

}
