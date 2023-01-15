package com.leecode.字符串;

public class _面试题_字符串轮转 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1 == null || s2 ==null ) return false;
        if (s1.length() != s2.length()) return false;
//        return (s1 + s2).contains(s2); --error 这里不是s1 +s2是s1 + s1
        //这里还可以考虑使用kmp算法
        return (s1 + s1).contains(s2);
    }
}
