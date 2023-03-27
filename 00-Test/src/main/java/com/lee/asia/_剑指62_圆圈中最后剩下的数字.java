package com.lee.asia;

public class _剑指62_圆圈中最后剩下的数字 {
    public int lastRemaining(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }

//    public int lastRemaining1(int n, int m) {
//        return (n == 1) ? 0 : (lastRemaining1(n-1,m ) + m ) % n;
//    }
}
