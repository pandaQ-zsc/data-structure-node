package com.lee.哈希表;

import java.util.HashSet;
import java.util.Set;

public class _349_两个数组的交集 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length ==0){
            return null;
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for(int num : nums1){
            set1.add(num);
        }
        for(int num : nums2){
            if (set1.contains(num)){
                resSet.add(num);
            }
        }
        //resSet 4 9
        int index = 0;
        int[] res = new int[resSet.size()];
        for (int i : resSet){
            res[index++] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] intersection = intersection(new int[]{4, 9, 5}, new int[]{9, 4, 8, 4});
        System.out.println(intersection);
    }
}
