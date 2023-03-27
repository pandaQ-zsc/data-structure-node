package com.lee.asia;

public class _50_Pow {
    public double myPow(double x, int n) {
        long N = n;
        return n > 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) return 1;
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
