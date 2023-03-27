package com.lee.哈希表;

import java.util.*;

//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
public class _49_字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
       if (strs.length == 0) return new ArrayList<>();
       Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
//            String s = Arrays.toString(chars);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
