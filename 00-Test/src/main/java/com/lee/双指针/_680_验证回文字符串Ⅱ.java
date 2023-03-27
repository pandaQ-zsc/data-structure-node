package com.lee.双指针;

public class _680_验证回文字符串Ⅱ {
    //输入: s = "aba"
    //输出: true
    //输入: s = "abbca"
    //输出: true
    //解释: 你可以删除c字符。
    public static boolean validPalindrome(String s) {
        char [] chars = s.toCharArray();

        int l = 0 , r = chars.length-1;
        while(l < r){
            if (chars[l] != chars[r]){
                //无法确定字符是多余的，需要左右都验证一下
                //同时这一步蕴含着  删除左右中多余的字符
                return validPalindrome(chars,l,r-1)
                        || validPalindrome(chars,l+1,r);
            }
            l++;
            r--;
        }
        return true;
    }

    private static boolean validPalindrome(char[] chars, int l, int r) {
        while(l < r){
            if (chars[l] != chars[r]){
                return false;
            }else {
                l++;
                r--;
            }
        }
        return true;
    }




}
