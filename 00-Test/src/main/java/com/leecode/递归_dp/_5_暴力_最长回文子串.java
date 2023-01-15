package com.leecode.递归_dp;

import java.util.Arrays;

//输入：s = "cbbd"
//输出："bb"
//输入：s = "babad"
//输出："bab"
public class _5_暴力_最长回文子串 {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > 0; j--) {
                if (j - i + 1 > maxLen) {
                    if (isPalindrome(s, i, j)) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static String longestPalindrome2(String s) {
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > 0; j--) {
                if (j - i + 1 > maxLen) {
                    if (isPalindrome(s, i, j)) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }


    public static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String abb = longestPalindrome("abb");
        System.out.println(abb);
    }
}
