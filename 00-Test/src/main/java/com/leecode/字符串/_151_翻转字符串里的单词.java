package com.leecode.字符串;

public class _151_翻转字符串里的单词 {
    public String reverseWords(String s) {
        if (s == null) return " ";
        //消除多余的空格
        char[] chars = s.toCharArray();
        //字符串的最终长度
        int len = 0;
        int cur = 0;
        //前一个空格是否为空格字符
        boolean space = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' '){  // cur[i]是非空格
              chars[cur++]  = chars[i];
              space = false;
            }else if (space == false){ // chars[i]是空格， chars[i-1]是非空格
                chars[cur++] = ' ';
                space = true;
            }
        }
        len = space ? cur - 1 : cur;
        if (len <= 0) return  null;
        //对整个有效字符串进行逆序
        reverse(chars,0,len);
        //哨兵
        int prevSpaceIndex= -1;
        for (int i = 0; i < len; i++) {
            if (chars[i] != ' ')continue;
            reverse(chars,prevSpaceIndex+1,i);
            prevSpaceIndex = i;
        }
        //反转最后一个单词
        reverse(chars,prevSpaceIndex+1,len);
        return  new String(chars,0,len);
    }
    private void reverse(char[] chars, int li, int ri){
        ri--;
        while(li < ri){
            char tmp  = chars[li];
            chars[li] = chars[ri];
            chars[ri] = tmp;
            li++;
            ri--;
        }
    }
}
