package com.lee.asia;

import com.sun.javafx.robot.FXRobotImage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xiong Qiang
 * @date 2024/6/1 10:15
 *
 */
//给你两个正整数 n 和 limit 。
//
//请你将 n 颗糖果分给 3 位小朋友，确保没有任何小朋友得到超过 limit 颗糖果
// 请你返回满足此条件下的 总方案数 。
public class _2928_给小朋友们分糖果2 {
    int ans = 0;public static int distributeCandies(int n, int limit) {
    int ans = 0;
    List<Integer> answerList = new ArrayList<>();
    for (int i = 0; i <= limit; i++) {
      for (int j = 0; j <= limit; j++) {
         if (i + j > n){
           break;
         }
         if (n-i-j <= limit){
           ans++;
           answerList.add(i);
           answerList.add(j);
           answerList.add(n-i-j);
           System.out.println(answerList);
         }
         answerList.clear();
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int  n = distributeCandies(5,2);
    System.out.println(n);
  }
}

