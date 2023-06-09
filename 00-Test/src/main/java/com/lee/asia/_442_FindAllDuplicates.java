package com.lee.asia;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiong.qiang
 * @date: 2023/5/25 17:55
 */
public class _442_FindAllDuplicates {

    public static List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        if (nums.length == 1) return list;
        int[] res = new int[nums.length+1];
        for(int num : nums){
            res[num]++;
        }
        for (int i = 1; i < res.length; i++) {
            if (res[i] >=2){
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }


}
