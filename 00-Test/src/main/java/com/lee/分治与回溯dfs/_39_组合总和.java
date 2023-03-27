package com.lee.分治与回溯dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39_组合总和 {

    private List<Integer> list;
    private List<List<Integer>> res;

    //输入: candidates = [2,3,6,7], target = 7
    //输出: [[7],[2,2,3]]
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        int sum = 0;
        Arrays.sort(candidates);
        dfs(candidates,target,sum,0);
        return res;
    }

    private void dfs(int[] candidates, int target, int sum,int idx) {
        if (sum > target) return;
        if (sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        //关键int i = idx： 这里的i++ 控制 253 第一层取 253 第二层中 5哪里不能取2
        // 因为candidate[i]这里已经成了candidate[1]了
        //如果int i =0 的话 那么每次都会从candidate[0]也就是2开始取值。会造成232 322重复
        for (int i = idx; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            list.add(candidates[i]);
            sum += candidates[i];
            // 关键点:不用i+1了，表示可以重复读取当前的数
            dfs(candidates,target,sum,i);
            sum -= candidates[i];
            list.remove(list.size()-1);
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
