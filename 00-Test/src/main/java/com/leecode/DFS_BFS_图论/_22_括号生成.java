package com.leecode.DFS_BFS_图论;

import java.util.ArrayList;
import java.util.List;

public class _22_括号生成 {
    //输入：n = 3
    //输出：["((()))","(()())","(())()","()(())","()()()"]

    List<String> res;
    public List<String> generateParenthesis(int n) {
        if (n == 0) return res;
        res = new ArrayList<>();
        dfs("",n,n);
        return res;
    }

    private void dfs(String s, int leftMain, int rightMain) {
        if (leftMain==0 && rightMain == 0){
            res.add(s);
        }
        if (leftMain > rightMain) return;
        if ( leftMain >0){
            dfs(s+"(",leftMain-1,rightMain);
        }
        if (rightMain >0){
            dfs(s+")",leftMain,rightMain-1);
        }
    }

    public static void main(String[] args) {
        _22_括号生成 v = new _22_括号生成();
        List<String> strings = v.generateParenthesis(3);
        System.out.println(strings);
    }

}
