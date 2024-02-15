package com.lee.asia;

/**
 * @author: xiong.qiang
 * @date: 2023/6/14 16:21
 */
public class _415_AddStrings {

    public static String addStrings(String num1, String num2) {
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        int arrIndex1 = num1.length()-1;
        int arrIndex2 = num2.length()-1;
        StringBuilder sb = new StringBuilder();
        int remainder = 0;
        while( arrIndex1 >=0 || arrIndex2 >=0){
            int n1 = arrIndex1>=0?(ch1[arrIndex1--] - '0') : 0;
            int n2 = arrIndex2>=0?(ch2[arrIndex2--] - '0') : 0;
            int num = remainder + n1 + n2;
            remainder = num/10;
            sb.append(num %10);
        }
        //考虑是否还需要进位   5000 5000
        if (remainder >0){
            sb.append(remainder);
        }
        return sb.reverse().toString();
    }

    public static String addStrings2(String num1, String num2) {
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        int remainder = 0;
        int index1 = ch1.length-1;
        int index2 = ch2.length-1;
        StringBuilder sb = new StringBuilder();
        while(index1>=0 || index2>0){
            int v1 = index1 >=0 ? (ch1[index1--] -'0'):0;
            int v2 = index2 >=0 ? (ch2[index2--] -'0'):0;
            int s = v1+v2+remainder;
            remainder = s/10;
            sb.append(s%10);
        }
        if (remainder >0){
            sb.append(remainder);
        }
        return sb.reverse().toString();


    }


    public static void main(String[] args) {
        System.out.println(addStrings2("9314", "996"));
    }
}
