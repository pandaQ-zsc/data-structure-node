package com.lee.哈希表;

import java.util.HashMap;
import java.util.Map;

public class _594_最长和谐子序列 {
    //输入：nums = [1,3,2,2,5,2,3,7]
    //输出：5
    //解释：最长的和谐子序列是 [3,2,2,2,3]
    public int findLHS(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;

        for( int num : nums){
            map.put(num, map.getOrDefault(num,0) +1);
        }
        for(int key : map.keySet()){
              if (map.containsKey( key + 1)){
                res = Math.max(res, map.get(key)+map.get(key+ 1));
              }
        }
        return res;

    }
}
