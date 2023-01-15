package com.leecode.哈希表;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _242_有效的字母异位词 {
    //输入: s = "anagram", t = "nagaram"
    //输出: true
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch2  = t.charAt(i);
            map.put(ch2,map.getOrDefault(ch2,0)-1);
            if (map.get(ch2) <0){
                return false;
            }
        }
        return true;
    }
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        return Arrays.equals(chars, chars1);
    }
    public boolean isAnagram3(String s, String t) {
        if (s.length()!= t.length()) return  false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars,tChars);

    }
}
