package com.lee.字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _3_无重复字符的最长子串 {
    //输入: s = "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    //输入: s = "pwwkew"
    //输出: 3
    //     abba  -- 2
    //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    //     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;//用于记录最大不重复子串的长度
        int left = 0;//滑动窗口左指针
        for (int i = 0; i < s.length(); i++) {
            /**
             1、首先，判断当前字符是否包含在map中，如果不包含，将该字符添加到map（字符，字符在数组下标）,
             此时没有出现重复的字符，左指针不需要变化。此时不重复子串的长度为：i-left+1，与原来的maxLen比较，取最大值；

             2、如果当前字符 ch 包含在 map中，此时有2类情况：
             1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
             那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
             2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
             而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
             随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
             应该不变，left始终为2，子段变成 ba才对。

             为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
             另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
             因此此时新的 s.charAt(i) 已经进入到 当前最长的子段中！
             */
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            //不管是否更新left，都要更新 s.charAt(i) 的位置！
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
    // 亲测有效 2022年4月28日14:52:55
    public int lengthOfLongestSubstring01(String s) {
        // abba   aba
        int maxLen = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i))+1);
            };
            map.put(s.charAt(i),i);
            maxLen = Math.max(maxLen,i-left+1);
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstring2(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int left= 0;
        int maxLength = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])){
                left = Math.max( map.get(chars[i])+1,left);
            }
            map.put(chars[i],i);
            maxLength = Math.max(maxLength,i-left+1);
        }
        return maxLength;


    }

    public static int lengthOfLongestSubstring4(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isTrue(i,j,s)){
                   res = Math.max(res,j-i);
                }
            }
        }
        return res;
    }

    private static boolean isTrue(int i, int j, String s) {
        HashSet<Character> set = new HashSet<>();
        for (int k = i; k <j ; k++) {
             if (set.contains(s.charAt(k))){
                 return false;
             }
             set.add(s.charAt(k));
        }
        return true;

    }

    //输入: s = "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    //输入: s = "pwwkew"
    //输出: 3

    public static int lengthOfLongestSubstring1(String s) {
                int n = s.length();
                int res = 0;
                int end=0,start=0;
                Set<Character> set=new HashSet<>();
                while(start<n && end<n){
                    if(set.contains(s.charAt(end))){
                        set.remove(s.charAt(start));
//                        set.clear();
                        start++;
                    }else{
                        set.add(s.charAt(end++));
                        res=Math.max(res,end-start);
                    }

                }
                return res;
    }


    public static void main(String[] args) {
        int abcabcbb = lengthOfLongestSubstring1("pwwk");
    }
}
