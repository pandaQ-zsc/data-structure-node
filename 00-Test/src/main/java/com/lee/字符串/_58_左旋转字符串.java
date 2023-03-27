package com.lee.字符串;


public class _58_左旋转字符串 {
    public String reverseLeftWords2(String s, int n) {
        int length = s.length();
        String s1 = s.substring(0, n);
        String s2 = s.substring(n,length);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s2);
        stringBuilder.append(s1);
        String s3 = stringBuilder.toString();
        return s3;
    }

        public String reverseLeftWords(String s, int n) {
            int len=s.length();
            StringBuilder sb=new StringBuilder(s);
            reverseString(sb,0,n-1);
            reverseString(sb,n,len-1);
            return sb.reverse().toString();
        }
        public void reverseString(StringBuilder sb, int start, int end) {
            while (start < end) {
                char tmp = sb.charAt(start);
                sb.setCharAt(start,sb.charAt(end));
                sb.setCharAt(end,tmp);
                start++;
                end--;
            }
        }

}
