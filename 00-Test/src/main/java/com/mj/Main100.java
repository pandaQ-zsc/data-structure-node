package com.mj;

import java.io.File;

public class Main100 {
    public static void main(String[] args) {
        String s = tryTrim("   ssjhsj   ");
        System.out.println("tryTrim" + s);
        String reverseRes = tryReverse("aasjdksdjk", 3, 6);//jdks
        System.out.println(reverseRes);
        File file = new File("/Users/xxx/IdeaProjects/data-structure-node/00-Test/src/main/java/com/mj/Main3.java");
        System.out.println(file + " --- ");

    }

    static String tryTrim(String str) {
        if (str != null) {
            int start = 0;
            int end = str.length() - 1;
            while (start < end && str.charAt(start) == ' ') {
                start++;
            }
            while (start < end && str.charAt(end) == ' ') {
                end--;
            }
            return str.substring(start, end + 1);
        }
        return null;

    }

    //将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
    static String tryReverse(String str, int startIndex, int endIndex) {
        str = str.substring(startIndex, endIndex + 1);
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    static String tryReverse1(String str, int startIndex, int endIndex) {
        if (str != null && str.length() != 0) {
            char[] arr = str.toCharArray();
            for (int x = startIndex, y = endIndex; x < y; x++, y--) {
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;
    }
}
