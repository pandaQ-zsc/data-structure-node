package com.lee.贪心;

public class _392_判断子序列 {
    //输入：s = "abc",
    //     t = "ahbgdc"
    //输出：true
    public boolean isSubsequence(String s, String t) {
       int n = s.length(), m = t.length();
       int i = 0; int j=0;
       while(i <n && j < m){
           if (s.charAt(i) == t.charAt(j)){
               i++;
           }
           j++;
       }
       return i == n;
    }
    public boolean isSubsequence2(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] dp = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            dp[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    dp[i][j] = i;
                else
                    dp[i][j] = dp[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (dp[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = dp[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}
