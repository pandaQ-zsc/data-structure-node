package com.lee.位运算;

public class _342_4的幂 {
    // 00001
    // 00100
    // 10000
    public static boolean isPowerOfFour(int n) {
        if (n<1) return false;
        while(n != 1){
            if (n%4 != 0){
                return false;
            }
            n = n /4;
        }
        return true;
    }
    public static boolean isPowerOfFour2(int n) {
        return n>0 && (n&(n-1)) == 0 && n %3 ==1;
    }

    public static void main(String[] args) {
        boolean powerOfFour = isPowerOfFour(15);
        System.out.println(powerOfFour);
    }
}
