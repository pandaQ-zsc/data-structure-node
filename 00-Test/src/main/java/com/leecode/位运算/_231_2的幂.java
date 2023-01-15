package com.leecode.位运算;

////只要每次执行这个操作 n & (n - 1)，就会消除掉 n 的二进制中 最后一个出现的 1。
////   n   : 110100
////  n-1  : 110011
//// n&n-1 : 110000
////算术右移 >> ：舍弃最低位，高位用符号位填补；
////逻辑右移 >>> ：舍弃最低位，高位用 0 填补。
//// 那么对于负数而言，其二进制最高位是 1，如果使用算术右移，
//// 那么高位填补的仍然是 1。也就是 n 永远不会为 0。所以下面的代码会超时 TLE。
public class _231_2的幂 {
    //给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回true,否则，返回 false 。
    //如果存在一个整数 x 使得n == 2x ，则认为 n 是 2 的幂次方。
    //
    //输入：n = 1
    //输出：true
    //解释：2^0 = 1
    // 特点： 10  100 1000 10000
    public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count == 1;

    }

    // n & (n-1) 角度思考
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
