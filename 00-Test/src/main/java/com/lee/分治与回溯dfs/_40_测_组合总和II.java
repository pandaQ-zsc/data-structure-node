package com.lee.分治与回溯dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_测_组合总和II {

    //输入: candidates [10,1,2,7,6,1,5], target =8,
    //输出:
    //[
    //[1,1,6],
    //[1,2,5],
    //[1,7],
    //[2,6]
    //]
    //回看一下题目，元素在同一个组合内是可以重复的，怎么重复都没事，但两个组合不能相同。
    //所以我们要去重的是同一树层上的“使用过”，同一树枝上的都是一个组合里的元素，不用去重。

    //此题还需要加一个bool型数组used，用来记录同一树枝上的元素是否使用过。
    //出现重复节点， 同层的第一个节点已经被访问过，就直接跳过
    //used[i - 1] == true，说明同一树支candidates[i - 1]使用过
    //used[i - 1] == false，说明同一树层candidates[i - 1]使用过
    //!flag[i-1] 表示同一树层 也就是for循环中的i。 如[1,1,2]中的第二个1
    //如[1,1,2]中的第二个1为true的时候此时flag数组为【0,1,0】
    //统一树枝的话 flag数组变化是是[1,0,0] -->[1,1,0]-->[1,1,1]
//            System.out.println(flag[i-1]);
    List<List<Integer>> res;
    List<Integer> list;
    int sum = 0;
    public  List<List<Integer>> combinationSum2(int[] candidates, int target){
        list = new ArrayList<>();
        res = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] flags = new boolean[candidates.length];
        dfs(candidates,flags,target,0);
        return res;

    }

    private void dfs(int[] candidates, boolean[] flags, int target, int begin) {
        if (sum == target){
            res.add(new ArrayList<>(list));
        }
        for (int i = begin; i < candidates.length && candidates[i] + sum <= target; i++) {
            if (i > 0 && candidates[i] == candidates[i-1] &&!flags[i-1]){
                continue;
            }
            list.add(candidates[i]);
            sum += candidates[i];
            flags[i] = true;
            dfs(candidates,flags,target,i+1);
            flags[i] = false;
            sum -= candidates[i];
            list.remove(list.size() - 1 );
        }
    }


}
