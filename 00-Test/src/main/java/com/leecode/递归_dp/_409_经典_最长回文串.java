package com.leecode.递归_dp;

public class _409_经典_最长回文串 {

    //扩展中心节点
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        char[] cs = s.toCharArray();
        //最长回文子串的长度（至少是1）
        int maxLen = 1;
        //最长回文子串的开始索引
        int begin = 0;
        int i = 0;
        while (i < cs.length) {
            //找到右边的第一个不等于cs[i]的位置
            //从l往左，从r往右扩展
            int l = i - 1;
            int r = i;
            while (++r < cs.length && cs[r] == cs[i]) ;
            i = r;
            while (l >= 0 && r < cs.length && cs[l] == cs[r]) {
                l--;
                r++;
            }
            //一次扩展结束后的长度
            int len = r - (l + 1);
            if (len > maxLen) {
                maxLen = len;
                begin = l + 1;
            }
        }
        return new String(cs, begin, maxLen);
    }

    public String longestPalindrome_test(String s) {
        if (s.length() <= 1) return s;
        int begin = 0;
        int i = 0;
        int maxLen = 1;
        char[] cs = s.toCharArray();
        //扫描一遍
        while (i < cs.length) {
            int l = i - 1;
            int r = i;
            while (++r < cs.length && cs[r] == cs[i]) ;
            i = r;
            while (l >= 0 && r < cs.length && cs[l] == cs[r]) {
                l--;
                r++;
            }
            int len = r - (l + 1);
            if (len > maxLen) {
                maxLen = len;
                begin = l + 1;
            }
        }
        return new String(cs, begin, maxLen);

    }


    //动态规划
    public String longestPalindrome_dp(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]); //j - i 代表长度减去 1
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

}
