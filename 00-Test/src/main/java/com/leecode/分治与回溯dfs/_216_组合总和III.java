package com.leecode.分治与回溯dfs;

import java.util.ArrayList;
import java.util.List;

public class _216_组合总和III {
    //找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，
    // 并且每种组合中不存在重复的数字。

    //输入: k = 3, n = 7
    //输出: [[1,2,4]]
    List<List<Integer>> res;
    List<Integer> list;

    public List<List<Integer>> combinationSum3(int k, int n) {
       res= new ArrayList<>();
       list = new ArrayList<>();
       int  sum =0;
       dfs(k,n,1,sum);
       return res;
    }

    private void dfs(int k, int n, int level, int sum) {
        if (sum > n) return;
        if (sum == n && list.size() == k){
            res.add(new ArrayList<>(list));
        }
        for (int i = level; i <=9 ; i++) {
            list.add(i);
            sum += i;
            dfs(k,n,i+1,sum);
            sum -= i;
            list.remove(list.size()-1);
        }
    }
}
