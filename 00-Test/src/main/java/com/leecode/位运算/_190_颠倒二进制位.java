package com.leecode.位运算;

//颠倒给定的 32 位无符号整数的二进制位。
public class _190_颠倒二进制位 {
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    public int reverseBits2(int n) {
       int res = 0 ;
        for (int i = 0; i < 32; i++) {
            res = (res<<1) + (n&1);
            n >>=1;
        }
        return res;
    }
}
