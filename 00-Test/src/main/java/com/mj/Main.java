package com.mj;
//对x的每个数字分别使用最少位数的二进制表示
//          2-> 10   1->1  3->11
// 21370 ->  10 1 11 111 0
//  A ：10 1 11 111 0
//  B ： A的反转  111 11 1 01
//  C ： 对B来 压缩1    11111101 -> 101    1001101 -> 10101

import java.util.Scanner;

//程序 : X --> C
//    2 10 99
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            String s = Integer.toString(a);
            String s1 = exchangeNum(s);
            System.out.println(s1);
        }


    }

    public static String exchangeNum(String tempStr) {
        String str = "";
        int i = 0;
        while (i < tempStr.length()) {
            String str2 = Integer.toBinaryString(Integer.valueOf(tempStr.charAt(i) + ""));
            str = str + str2;
            i++;
        }
        StringBuffer sb = new StringBuffer(str);
        str = sb.reverse().toString();
        while (str.charAt(0) == '0') {
            str = str.substring(1);
        }
        int pre = 0;
        int after = 1;
        for (int j = 0; after < str.length(); j++) {
            if (str.charAt(pre) == str.charAt(after)) {
                if (pre == 0) {
                    str = str.substring(0, 1) + str.substring(after + 1);
                } else if (pre > 0) {
                    str = str.substring(0, pre + 1) + str.substring(after + 1);
                }
            } else {
                pre++;
                after++;
            }
        }
        return str;
    }

}