package com.lee.贪心;

public class _738_单调递增的数字 {
    /**
     * n   = 1234321
     * res = 1233999
     *
     * 13332 12999
     * 思路：
     *  从右向左扫描数字，若发现当前数字比其左边一位（较高位）小，
     *  则把它的左边一位数字减1，并将减一那个位置后面的所有位改成9
     */
    public static int monotoneIncreasingDigits(int n) {
      String s  = Integer.toString(n);
        char[] chars = s.toCharArray();
        int flag = chars.length;
        for (int i = chars.length-1; i >= 1; i--) {
            if (chars[i-1] > chars[i]){
                flag = i;
                chars[i-1]--;
            }
        }
        for (int i = flag; i <chars.length ; i++) {
            chars[i] = '9';
        }
        int i = Integer.parseInt(new String(chars));
        return i;
    }

    public static void main(String[] args) {
        monotoneIncreasingDigits(1234321);
    }
}
