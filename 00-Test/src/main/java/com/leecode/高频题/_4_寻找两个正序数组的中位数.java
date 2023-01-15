package com.leecode.高频题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class _4_寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double mid;
        List<Double> list = new ArrayList<>();
        for(int num : nums1){
            list.add((double) num);
        }
        for (int num : nums2){
            list.add((double) num);
        }
        Collections.sort(list);
        int size = list.size();
        if (size %2 == 0){
            mid = (list.get(size >> 1) + list.get((size >> 1) - 1)) / 2;
        }else {
            mid = list.get(size>>1);
        }
        return mid;

    }
}
