package com.lee.分治与回溯dfs;

import java.util.ArrayList;
import java.util.List;

public class _78_测_子集 {
    //输入：nums = [1,2,3]
    //输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    //:TODO:解法：
    // for循环，横向遍历 {1} -> {2} -> {3}
    //dfs递归：纵向遍历 {1} -> {1,2} -> {1,2,3}
    // 每次遍历加一个大于原来数下标的数到集合，把集合加入到结果集
    // 求取子集问题，不需要任何剪枝！因为子集就是要遍历整棵树。

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list;

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) return res;
        list = new ArrayList<>();
        dfs(0, nums);
        return res;
    }

    private void dfs(int begin, int[] nums) {
        res.add(new ArrayList<>(list));
        for (int i = begin; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(i+1,nums);
            list.remove(list.size()-1);
        }
    }


}
