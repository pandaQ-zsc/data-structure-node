package com.lee.asia;

public class _50_Pow_2 {
    public double myPow(double x, int n) {
        boolean neg = n < 0;
        long y = neg ? -((long) n) : n;
        double res = 1.0;
        while (y > 0) {
            if ((y & 1) == 1) {
                //如果最后一个二进制位是1,就累乘上x
                res *= x;
            }
            x *= x;
            //舍弃掉一个二进制位
            y >>= 1;

        }
        return neg ? (1 / res) : res;
    }

}
