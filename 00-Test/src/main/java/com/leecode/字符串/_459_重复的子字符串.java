package com.leecode.字符串;

public class _459_重复的子字符串 {
    //a baba b
    public boolean  repeatedSubstringPattern(String s) {
        String tmp = s + s;
        return tmp.substring(1,tmp.length()-1).contains(s);
    }
}
