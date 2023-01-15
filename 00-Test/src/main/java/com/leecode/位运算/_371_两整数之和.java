package com.leecode.位运算;

public class _371_两整数之和 {
    // 1.a+b   a == 0 时  a + b == b
    // 2.a != 0时，
    // 当a与b的二进制表示相同的位不存在同时为1时， a + b = a ^ b; ^:表示异或： 相同为0不同为1
    // 例如 2(10) + 1(01) = 3(11)
    // 而在相同的位存在都为1的情况 如a = 2 b = 3的时候
    // 可通过a^b 得出 a + b 减去进位后的结果:a(10)^b(01) = 1(01)进位为4(100)
    // 而通过a&b可得出进位左移一位后的结果，a(10)&b(11) = 2(10)==4(100)>>1
    // 因此 当a!=0时， 永远可以通过 a+b = a ^b + (a & b) << 1 来获取结果
    // 也就是a&b为新的a和b
    // 当a&b ==0 （即递归下一层的a）时，说明a与b的二进制表示在相同位不存在同时为1的条件，直接返回b
    public int getSum(int a, int b) {
        while(b != 0){
            int carry = (a & b)<< 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
    public int getSum2(int a, int b) {
        if ( a == 0){
            return  b;
        }
        int t = a & b;
        int d = a ^ b;
        return getSum2(t<<1,d);
    }
}
