package com.leecode.字符串;


import java.util.Arrays;

public class _344_反转字符串 {
    public void reverseString(char[] s) {
        int l = 0 , r = s.length-1;
        while(l < r ){
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++ ; r--;
        }
    }
}
