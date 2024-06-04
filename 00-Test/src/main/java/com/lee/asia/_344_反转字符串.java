package com.lee.asia;

import java.util.Arrays;

/**
 * Created by XQ
 * 2022/8/2
 */
public class _344_反转字符串 {
//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
//
//不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
//
//输入：s = ["h","e","l","l","o"]
//输出：["o","l","l","e","h"]

    //来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/reverse-string
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new int[]{1,2,3,4}));
        System.out.println(reverseString2(new char[]{'a', 'b', 'c','d','e'}));
    }

    public static char[] reverseString(char[] s) {
        int l = 0 ;
        int r = s.length-1;
        while(l < r){
            s[l] ^= s[r];   //  l^r
            s[r] ^= s[l];  //  r^l^r
            s[l] ^= s[r];   // l^l^r
            l++;
            r--;
        }
        return s;
    }


    public static char[] reverseString2(char[] s) {
        for (int l= 0,r = s.length-1; l<r; l++,r--) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            System.out.println(l);
            System.out.println(r);
        }
//        while(l < r){
//            char tmp = s[l];
//            s[l] = s[r];
//            s[r] = tmp;
//            l++;
//            r--;
//        }
        return s;
    }
}
