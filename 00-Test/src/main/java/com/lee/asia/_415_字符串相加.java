package com.lee.asia;

//整体思路： 先创建一个StringBuilder  记录进位carry
//   carry加上nums1的最后一位和nums2的最后一位  然后把个位数给sb
//   carry再/10
public class _415_字符串相加 {
    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int carry = 0;
        while (i1 >= 0 || i2 >= 0 || carry > 0) {
            if (i1 >= 0) carry += num1.charAt(i1--) - '0';
            if (i2 >= 0) carry += num2.charAt(i2--) - '0';
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = addStrings("12", "123456");
        System.out.println(s);

    }
}
