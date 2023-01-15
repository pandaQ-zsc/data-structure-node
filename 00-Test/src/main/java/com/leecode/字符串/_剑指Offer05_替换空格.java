package com.leecode.字符串;

public class _剑指Offer05_替换空格 {
    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }


    public static String replaceSpace2(String s) {
        int length = s.length() *3;
        int[] res = new int[length];
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                res[size++] ='%';
                res[size++] ='2';
                res[size++] ='0';
            }else {
                res[size++] =ch;
            }
        }
        return  new String(res,0,size);
    }

    public static void main(String[] args) {
        replaceSpace("We are happy.");
    }
}
