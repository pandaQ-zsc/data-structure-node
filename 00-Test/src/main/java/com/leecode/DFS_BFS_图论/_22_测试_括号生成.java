package com.leecode.DFS_BFS_图论;

import java.util.ArrayList;
import java.util.List;

public class _22_测试_括号生成 {
    //输入：n = 3
    //输出：["((()))","(()())","(())()","()(())","()()()"]
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if ( n == 0) return res;
        dfs("",n,n,res);
        return  res;
    }

    private void dfs(String s, int left, int right, List<String> res) {
        if (left == 0 && right ==0) res.add(s);
        if (left>right) return;
        if (left > 0){
        dfs( s + "(" ,left -1,right,res);
        }
        if (right > 0){
        dfs( s + ")" ,left,right-1,res);
        }
    }
}
