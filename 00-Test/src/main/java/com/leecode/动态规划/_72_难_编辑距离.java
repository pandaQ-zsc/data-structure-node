package com.leecode.动态规划;

public class _72_难_编辑距离 {
    //给你两个单词word1 和word2，请你计算出将word1转换成word2 所使用的最少操作数
    //输入：word1 = "horse", word2 = "ros"
    //输出：3
    //解释：
    //horse -> rorse (将 'h' 替换为 'r')
    //rorse -> rose (删除 'r')
    //rose -> ros (删除 'e')
    //
    //你可以对一个单词进行如下三种操作：
    //插入一个字符
    //删除一个字符
    //替换一个字符
    //
    public int minDistance(String word1, String word2) {
          if (word1 == null || word2 == null){
              return 0;
          }
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int [][] dp = new int[chars1.length+1][chars2.length+1];
        dp[0][0] = 0;
        for (int i = 1; i <= chars1.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= chars2.length; i++) {
            dp[0][i] = i ;
        }
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <=chars2.length ; j++) {
                int left =dp[i][j-1]+1;
                int top = dp[i-1][j]+1;
                //hors|e -->ro|e 这种情况
                int leftTop = dp[i-1][j-1];
                //dp[i][j]对应的字符 chars[i-1][j-1]
                if (chars1[i-1] != chars2[j-1]) leftTop++;
                dp[i][j] = Math.min(leftTop,Math.min(left,top));
            }
        }
        return dp[chars1.length][chars2.length];
    }
}
