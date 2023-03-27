package com.lee.递归_dp;

public class _1143_最长公共子序列 {
    //输入：text1 = "abcde", text2 = "ace"
    //输出：3
    //解释：最长公共子序列是 "ace" ，它的长度为 3 。

    // dp[i][j]   nums1前i个元素与 num2前j个元素
    //  前i个元素最后一个元素下表是i-1
    public int longestCommonSubsequence(String text1, String text2) {
        int [][] dp = new int[2][text2.length()+1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                //  前i个元素最后一个元素下表是i-1
//                if (text1.charAt(i) == text2.charAt(j) ){  --- false
                int row = i & 1;
                int preRwo = (i -1) & 1;
                if (text1.charAt(i-1) == text2.charAt(j-1) ){
                    dp[row][j] = dp[preRwo][j-1]+1;
                }else {
                    dp[row][j] = Math.max(dp[preRwo][j],dp[row][j-1]);
                }
            }
        }
        return dp[text1.length() & 1][text2.length()];
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        int [][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
//                if (text1.charAt(i) == text2.charAt(j) ){  --- false
                //  前i个元素最后一个元素下表是i-1
                if (text1.charAt(i-1) == text2.charAt(j-1) ){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
