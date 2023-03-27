package com.lee.DFS_BFS_图论;

import java.util.ArrayList;
import java.util.List;
public class _17_电话号码的字母组合 {
    public static void main(String[] args) {
        _17_电话号码的字母组合 v = new _17_电话号码的字母组合();
        List<String> strings = v.letterCombinations("23");
        System.out.println(strings);
    }
    private char[][] lettersArray = {
            //digits[i] 是范围 ['2', '9'] 的一个数字。
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };
    private char[] chars;
    //用来存储每一层选择的字母
    private char[] string;
    private List<String> list;

    public List<String> letterCombinations(String digits) {
        if (digits == null) return null;
        list = new ArrayList<>();
        // chars ： "2"  "23"
        chars = digits.toCharArray();
        if (chars.length == 0) return list;
        string = new char[chars.length];
        dfs(0);
        return list;
    }

    private void dfs(int idx) {
        //最后超过最后一层就回溯到dfs(idx)然后for (char letter : letters)遍历下一个字符
        if (idx == chars.length) {
            list.add(new String(string));
            return;
        }
        // chars : "2"  "23" "24"
        //chars[idx] = chars[0] = 2 ->lettersArray[chars[idx] - '2'] -> lettersArray[0] = {'a','b','c'}这种形式
        // 选择lettersArray的第0个{'a','b','c'}
        char[] letters = lettersArray[chars[idx] - '2'];
        //letters {'a','b','c'}
        for (char letter : letters) {
            string[idx] = letter;
            dfs(idx + 1);
        }
    }


}
