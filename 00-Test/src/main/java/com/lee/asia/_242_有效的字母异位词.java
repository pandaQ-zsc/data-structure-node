package com.lee.asia;

import java.util.HashMap;

/**
 * Author: xiong.qiang
 * Date: 2022/12/29 15:03
 */
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。

//示例1:
//输入: s = "anagram", t = "nagaram"
//输出: true
//示例 2:
//
//输入: s = "rat", t = "car"
//输出: false
//
//链接：https://leetcode.cn/problems/valid-anagram
public class _242_有效的字母异位词 {
    //ok 1
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int[] countArray = new int[26];
        for (char c : sArray) {
            countArray[c - 'a']++;
        }
        for (int i = 0; i < tArray.length; i++) {
            // 注意：如果是 countArray[tArray[i] - 'a']-- 的话意味着会造成： countArray先赋值给i1  再进行countArray--  这样i1就不是--后值
            int i1 = --countArray[tArray[i] - 'a'];
            if (i1 < 0) {
                return false;
            }
        }
        return true;
    }
    //test
    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int[] countArray = new int[26];
        for(int i = 0 ; i < s.length(); i++){
            countArray[s1[i] - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
             int tmp = --countArray[t1[i] - 'a'];
             if (tmp  < 0){
                 return false;
             }
        }
        return true;
    }


    //ok2
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        boolean anagram = isAnagram3("abbba", "bbbaa");
        System.out.println(anagram);

    }
}
