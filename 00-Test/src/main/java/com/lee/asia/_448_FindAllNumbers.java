package com.lee.asia;

import cn.hutool.core.convert.Convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: xiong.qiang
 * @date: 2023/5/25 17:37
 */
public class _448_FindAllNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] res = new int[nums.length+1];
        for(int num : nums){
            res[num]++;
        }
        for (int i = 1; i < res.length; i++) {
            if (res[i] ==0){
                ans.add(i);
            }
        }
        return ans;
    }

    //Input: nums = [4,3,2,7,8,2,3,1]
    //Output: [5,6]
    //Input: nums = [1,1]
    //Output: [2]
    public static void main(String[] args) {
//        int[] a = new int[]{4,3,2,7,8,2,3,1};
        int[] a = new int[]{1,1};
        List<Integer> numbers = findDisappearedNumbers(a);
        System.out.println(Convert.toStr(numbers));

    }
}
