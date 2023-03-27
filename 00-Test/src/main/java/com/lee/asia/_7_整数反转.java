package com.lee.asia;

public class _7_整数反转 {
    //https://leetcode-cn.com/problems/reverse-integer/solution/tu-jie-7-zheng-shu-fan-zhuan-by-wang_ni_ma/
    //假设有1147483649这个数字，它是小于最大的32位整数2147483647的，
    // 但是将这个数字反转过来后就变成了9463847411，这就比最大的32位整数还要大了，这样的数字是没法存到int里面的，所以肯定要返回0(溢出了)。
    //
    //作者：wang_ni_ma
    //链接：https://leetcode-cn.com/problems/reverse-integer/solution/tu-jie-7-zheng-shu-fan-zhuan-by-wang_ni_ma/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int reverse(int x) {
        int res = 0;
        int last = 0;
        while (x != 0) {
            int tmp = x % 10;
            last = res;
            res = res * 10 + tmp;
            if (res / 10 != last) {
                return 0;
            }
            x = x / 10;
        }
        return res;
    }

    public int reverse1(int x) {
        if (x == 0) return 0;
        int res = 0;
        boolean flag = false;
        if (x < 0) {
            flag = true;
        }
        x = Math.abs(x);
        while (x != 0) {
            //本来是 res * 10 + x%10 >Integer.MAX_VALUE
            //全部右移 res > (Integer.MAX_VALUE -x%10)/10
            if (res > (Integer.MAX_VALUE - x % 10) / 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return flag ? -res : res;
    }

    //取巧了
    public int reverse2(int x) {
        long res = 0;
        while (x != 0) {
            res = x % 10 + res * 10;

            x /= 10;

        }
        return (int) res == res ? (int) res : 0;
    }
}
