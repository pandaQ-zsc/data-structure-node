package com.lee.字符串;

import java.util.*;
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//输入: s = "pwwkew"
//输出: 3
//     abba  -- 2
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

public class _3_测_无重复字符的最长子串 {
    public static int lengthOfLongestSubstring(String s) {
        // abba   aba
        int maxLen = 0; //map存储  Char,当前位置。
        int left = 0; // 上一个值
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                maxLen = Math.max(maxLen,i- left);
                left = i;
            }else {
                map.put(s.charAt(i),i);
                maxLen = Math.max(maxLen,i-left+1);
            }
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring01(String s) {
        // abba   aba
        int maxLen = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i))+1);
            };
            map.put(s.charAt(i),i);
            maxLen = Math.max(maxLen,i-left+1);
        }
        return maxLen;
    }

    public static void test01(){
        Integer i = 10;
    }
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbbqwe"));
        test01();
    }
}
