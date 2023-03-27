package com.lee.分治与回溯dfs;

import java.util.*;

//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]


public class _17_电话号码的字母组合 {
    List<String> res;
    StringBuilder tmp = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(digits, numString, 0);
        return res;
    }

    private void dfs(String digits, String[] numString, int level) {
        if (level == digits.length()) {
            res.add(tmp.toString());
            return;
        }
        String str = numString[digits.charAt(level) - '0'];
        for (int i = 0; i < str.length(); i++) {
            tmp.append(str.charAt(i));
            dfs(digits, numString, level + 1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
