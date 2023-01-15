package com.leecode.哈希表;

import java.util.HashSet;
import java.util.Set;

//输入：19
//输出：true
//解释：
//1^2 + 9^2 = 82
//8^2 + 2^2 = 68
//6^2 + 8^2 = 100
//1^2 + 0^2 + 0^2 = 1
public class _202_快乐数 {
    public static boolean isHappy(int n) {
       Set<Integer> set = new HashSet<>();
       if (n != 1 && !set.contains(n)){
           set.add(n);
           n = getNextNumber(n);
       }
       return n == 1;
    }
    //19
    private static int getNextNumber(int n) {
       int tmpSum = 0;
       while(n > 0) {
           int tmp = n %10;
           tmpSum += tmp * tmp;
           n /= 10;
       }
       return tmpSum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }


}
