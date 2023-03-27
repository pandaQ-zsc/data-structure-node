package com.lee.分治与回溯dfs;

//输入：x = 2.00000, n = 10
//输出：1024.00000

//分治的思想 ：  求x的n此房 可以先求x的 n/2此方
public class _50_Powx_n {
    public double myPow(double x, int n) {
        long N = n ;
        return N >= 0? quickMul(x,N) : 1/ quickMul(x,-N);
    }
    public double quickMul(double x ,long N){
        if ( N == 0 ) return  1.0;
        double y = quickMul(x,N/2);
        return N%2 == 0 ? y * y : y *y*x;
    }

}
