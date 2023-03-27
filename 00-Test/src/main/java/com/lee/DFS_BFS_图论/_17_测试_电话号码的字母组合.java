package com.lee.DFS_BFS_图论;

import java.util.ArrayList;
import java.util.List;

public class _17_测试_电话号码的字母组合 {
    private char[][] lettersArray = {
            //digits[i] 是范围 ['2', '9'] 的一个数字。
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };
    private char[] string;
    private List<String> list;
    private char[] chars;

    public List<String> letterCombinations(String digits) {
        //  2 3
        chars = digits.toCharArray();
        list = new ArrayList<>();
        if (digits.length() == 0) return list;
        string = new char[chars.length];
        dfs(0);
        return list;

    }

    private void dfs(int idx) {
        //最终
        if (idx == chars.length) {
            list.add(new String(string));
            return;
        }
        //递归
        char[] letters = lettersArray[chars[idx] - '2'];
        for (char letter : letters) {
            string[idx] = letter;
            dfs(idx + 1);
        }
    }


}
