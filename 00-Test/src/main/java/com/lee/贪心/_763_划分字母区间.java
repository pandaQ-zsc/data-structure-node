package com.lee.贪心;

import java.util.ArrayList;
import java.util.List;

//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]

public class _763_划分字母区间 {
    public static List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0){
            return null;
        }
        List<Integer> res = new ArrayList<>();
        int right=0 , len = s.length();
        int[] cache = new int[26];
        for (int i = 0; i < len; i++) {
            cache[s.charAt(i) - 'a'] = i;
        }
        for(int ca : cache){
            System.out.print(ca+"_");
        }
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right,cache[s.charAt(i)-'a']);
            if (i == right){
                res.add(right-left+1);
                left = i+1;
            }
        }
        return res;
    }
    ////输入：S = "ababcbacadefegdehijhklij"
    ////输出：[9,7,8]
    public static List<Integer> partitionLabels2(String s) {
      if (s == null || s.length() == 0){
          return null;
      }
      List<Integer> res = new ArrayList<>();
      int[] cache = new int[26];
        for (int i = 0; i < s.length(); i++) {
             cache[s.charAt(i) - 'a'] = i;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right,cache[s.charAt(i)-'a']);
            if (right == i){
                res.add(right-left+1);
                left =right+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        partitionLabels2("ababcbacadefegdehijhklij");
    }
}
