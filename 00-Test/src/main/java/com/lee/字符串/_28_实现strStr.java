package com.lee.字符串;

//输入：haystack = "hello", needle = "ll"
//输出：2
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
public class _28_实现strStr {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i+m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i+j) !=needle.charAt(j) ){
                    flag = false;
                    break;
                }
            }
            if (flag) return i;
        }
        return -1;
    }
    public int strStr2(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0 ; j <m ; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)){
                    flag = false;
                }
            }
            if (flag){
                return i;
            }
        }
        return -1;
    }
}
