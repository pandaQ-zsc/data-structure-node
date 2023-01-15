package com.leecode.高频题;

public class _72_参考_编辑距离 {
    //https://leetcode-cn.com/problems/edit-distance/solution/edit-distance-by-ikaruga/
    //定义 dp[i][j]
    //21. dp[i][j] 代表 word1 中前 i 个字符，变换到 word2 中前 j 个字符，最短需要操作的次数
    //22. 需要考虑 word1 或 word2 一个字母都没有，即全增加/删除的情况，
    // 所以预留 dp[0][j] 和 dp[i][0]
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        dp[0][0] = 0;
        //第0列
        for (int i = 1; i <= chars1.length; i++) {
            dp[i][0] = i;
        }
        //第0行
        for (int j = 1; j <= chars2.length; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                int left = dp[i][j - 1] + 1;
                int top = dp[i - 1][j] + 1;
                //hors|e -->ro|e 这种情况
                int leftTop = dp[i - 1][j - 1];
                //dp[i][j]对应的字符 chars[i-1][j-1]
                if (chars1[i - 1] != chars1[j - 1]) leftTop++;
                dp[i][j] = Math.min(leftTop, Math.min(left, top));
            }
        }
        return dp[chars1.length][chars2.length];
    }

    public int minDistance2(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int [][] dp = new int[chars1.length+1][chars2.length+1];
        dp[0][0]=1;
        for (int i = 1; i < chars1.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <chars2.length ; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <=chars2.length ; j++) {
                int left = dp[i][j-1]+1;
                int right = dp[i-1][j]+1;
                int leftRight = dp[i-1][j-1];
                if (chars1[i-1] != chars2[j-1]){
                    leftRight++;
                }
                dp[i][j] = Math.min(leftRight,Math.min(left,right));
            }
        }
        return dp[chars1.length][chars2.length];


    }

}
