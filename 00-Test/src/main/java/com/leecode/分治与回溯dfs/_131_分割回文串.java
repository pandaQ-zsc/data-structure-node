package com.leecode.分治与回溯dfs;

import java.util.ArrayList;
import java.util.List;

public class _131_分割回文串 {
    //输入：s = "aab"
    //输出：[["a","a","b"],["aa","b"]]
    List<List<String>> res;
    List<String> list;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int start) {
        if (start == s.length()){
            res.add(new ArrayList<>(list));
        }
        for (int i = start; i <s.length() ; i++) {
            if (isPalindrome(start,i,s)){
               list.add(s.substring(start,i+1));
               dfs(s,i+1);
               list.remove(list.size()-1);
            }
        }
    }

    //【l,r】
    public boolean isPalindrome(int l, int r, String s) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        _131_分割回文串 v = new _131_分割回文串();
        v.partition("aab");
    }

}
