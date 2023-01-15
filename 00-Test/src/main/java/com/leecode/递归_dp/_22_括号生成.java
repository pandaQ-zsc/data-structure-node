package com.leecode.递归_dp;

import java.util.ArrayList;
import java.util.List;

public class _22_括号生成 {
    List<String> res = new ArrayList<>();
    //输入：n = 3
    //输出：["((()))","(()())","(())()","()(())","()()()"]
    public List<String> generateParenthesis(int n) {
        if (n == 0 ) return res;
        dfs(n,0,0,"");
        return res;
    }

    private void dfs(int n, int l, int r, String s) {
        if (l== n & r==n){
            res.add(s);
        }
        if (l < n){
            dfs(n,l+1,r,s+"(");
        }
        //剪枝： 这里是精髓
        if (r < l){
            dfs(n,l,r+1,s+")");
        }

    }
}
