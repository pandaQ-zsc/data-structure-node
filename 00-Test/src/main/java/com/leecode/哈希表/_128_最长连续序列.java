package com.leecode.哈希表;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _128_最长连续序列 {
    //输入：nums = [100,4,200,1,3,2]
    //输出：4
    //解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4

    //1、定义一个哈希表hash，将nums数组中的数都放入哈希表中。
    //2、遍历哈希表hash，如果当前数x的前驱x-1不存在，我们就以当前数x为起点向后枚举。
    //3、假设最长枚举到了数y，那么连续序列长度即为y-x+1。
    //4、不断枚举更新答案。

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int res = 0;
        for(int i : nums){
            set.add(i);
        }
        for(int x : set){
            if (!set.contains(x -1)){
            int count = 1;
                int y = x;
                while( set.contains( y +1)){
                    count++;
                     y++;
                }
//                res = Math.max(res,y-x+1);
                res = Math.max(res,count);
            }
        }
        return res;
    }

    //输入：nums = [100,4,200,1,3,2]
    //输出：4
    //解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int num : nums){
            set.add(num);
        }
        for(int setNum : set){
            if (!set.contains(setNum - 1)){
                int curLength =1 ;
                 int curNum= setNum ;
                while (set.contains(curNum + 1)){
                    curNum++;
                    curLength++;
                }
                res =  Math.max(res,curLength);
            }
        }
        return res;
    }
}
