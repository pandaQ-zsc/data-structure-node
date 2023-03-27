package com.lee.字符串;

import cn.hutool.core.io.resource.ResourceUtil;

import java.net.URL;

public class _242_有效的字母异位词 {
    //首先这道题想到统计个数  最先应该想到 hashmap (k,v)形式
    //考虑到优化 就用char[]形式
    public boolean isAnagram(String s, String t) {
        URL resource = ResourceUtil.getResource("/etc/hosts");

        if (s == null || t == null) return false;
        int length = s.length();
        //这里是26个字母
        int[] count = new int[26];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        if (sChars.length != tChars.length) return false;
        for (int i = 0; i < length; i++) {
            count[sChars[i] - 'a']++;
        }
        for (int i = 0; i < length; i++) {
//            int i1 = count[tChars[i] - 'a']-1;   --error
//            if (i1 < 0) return  false;
//            if (--count[tChars[i]-'a']<0) return false;  --right
            count[tChars[i] - 'a']--;
            if (count[tChars[i] - 'a'] < 0) return false;
        }

        return true;
    }
}
