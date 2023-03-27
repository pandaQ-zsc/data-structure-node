package com.lee.分治与回溯dfs;

import java.util.ArrayList;
import java.util.List;

public class _491_递增子序列 {
    //输入：nums = [4,6,7,7]
    //输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
    //
    List<List<Integer>> res;
    List<Integer>list;
    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        if (nums.length == 0) return res;
        dfs(0,nums);
        return res;

    }


    private void dfs(int start, int[] nums) {
        if (list.size()>=2){
            res.add(new ArrayList<>(list));
        }
            int[] used = new int[201];
        for (int i = start; i <nums.length ; i++) {
            if (!list.isEmpty() && nums[i] < list.get(list.size()-1)
                    //避免回溯的时候同层下
        || used[nums[i] + 100] == 1) continue;
//            if (i>start && nums[i]== nums[i-1]){
//                continue;
//            }
//            if (!list.isEmpty() && nums[i] < list.get(list.size()-1)){
//                continue;
//            }
            //只是针对本层有用， 因为dfs每次传递下去 都会 int[] used = new int[201];
            //重置
                used[nums[i] + 100] = 1;
                list.add(nums[i]);
                dfs(i+1,nums);
                list.remove(list.size()-1);
        }

    }
}
