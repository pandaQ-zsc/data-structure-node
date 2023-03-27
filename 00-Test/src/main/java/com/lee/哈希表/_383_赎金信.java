package com.lee.哈希表;

import java.util.HashMap;

public class _383_赎金信 {
    //输入：ransomNote = "a", magazine = "b"
    //输出：false
    //输入：ransomNote = "aa", magazine = "aab"
    //输出：true
    //"aab"
    //"baa"   true
    public static boolean  canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) - 1);
                if (map.get(ch) <= 0) {
                    map.remove(ch);
                }
            }
            if (map.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static boolean  canConstruct2(String ransomNote, String magazine) {
        //记录数组次数
       char[] count = new char[26];
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (count[ransomNote.charAt(i) - 'a'] == 0) return false;
            count[ransomNote.charAt(i) - 'a'] --;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = canConstruct2("aa", "aab");
        System.out.println(b);
    }
}
