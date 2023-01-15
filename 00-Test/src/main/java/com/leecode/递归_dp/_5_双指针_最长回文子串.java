package com.leecode.递归_dp;

//输入：s = "cbbd"
//输出："bb"
//输入：s = "babad"
//输出："bab"
//https://leetcode-cn.com/problems/longest-palindromic-substring/solution/chao-jian-dan-de-zhong-xin-kuo-san-fa-yi-qini/
public class _5_双指针_最长回文子串 {
    public static String longestPalindrome(String s) {
        int len = s.length();
        String res = "";
        for (int i = 0; i < len; i++) {
            String s1 = palindrome(s,i,i);
            String s2 = palindrome(s,i,i+1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return  res;
    }
    private static String palindrome(String s, int left, int right){
        while(left >=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left++;
            right--;
        }
        return s.substring(left+1,right);
    }


    public static void main(String[] args) {
        String abb = longestPalindrome("abb");
        System.out.println(abb);
    }
}
