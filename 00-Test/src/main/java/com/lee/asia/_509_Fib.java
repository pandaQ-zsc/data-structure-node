package com.lee.asia;

import java.sql.SQLOutput;

/**
 * @author: xiong.qiang
 * @date: 2023/3/31 17:09
 */
public class _509_Fib {
    //best way

    // 0 1 1 2 3 5
    public static int fib(int n) {
        int first = 0;
        int second = 1;
        int sum = 0;
        if (n <=1){
            return  n;
        }
        for (int i = 0; i < n - 1; i++) {
              sum  = first + second;
              first = second;
              second = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            System.out.println(i+ " -> "+ fib(i));
        }
    }


    // more time
    public int fib2(int n) {
        if (n ==0){
            return 0;
        }
        if (n ==1){
            return 1;
        }
        return  fib2(n-1) + fib2(n-2);
    }
}
