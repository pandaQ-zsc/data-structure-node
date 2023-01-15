package com.leecode.分治与回溯dfs;

import java.util.ArrayList;
import java.util.List;

public class _77_组合 {
    private List<List<Integer>> res;
    private List<Integer> list;
    //示例 1：
    //
    //输入：n = 4, k = 2
    //输出：
    //[
    //  [2,4],
    //  [3,4],
    //  [2,3],
    //  [1,2],
    //  [1,3],
    //  [1,4],
    //]

    public  List<List<Integer>> combine(int n, int k) {
        res  = new ArrayList<>();
        list = new ArrayList<>();
        dfs(n,k,1);
        return res;
    }

    private void dfs(int n, int k, int level) {
        if (list.size() == k){
            res.add(new ArrayList<>(list));
        }
        for (int i = level; i <=n ; i++) {
            list.add(i);
            dfs(n,k,i+1);
            list.remove(list.size()-1);
        }
    }
}
