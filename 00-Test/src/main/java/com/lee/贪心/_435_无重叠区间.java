package com.lee.贪心;

import java.util.Arrays;

public class _435_无重叠区间 {
    //输入: [ [1,2], [2,3], [3,4], [1,3] ]
    //输出: 1
    //解释: 移除 [1,3] 后，剩下的区间没有重叠。
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });
        int axis = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (axis <= intervals[i][0]) {
                count++;
                axis = intervals[i][1];
            }
        }
        return intervals.length - count;
    }

    public int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals.length == 0 ) return 0;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int count = 0 ;
        int axis = intervals[0][1];
        for (int i = 1; i <intervals.length ; i++) {
            if (axis >intervals[i][0]){
                count++;
                axis = Math.min(axis,intervals[i][1]);
            }else {
                axis = intervals[i][1];
            }

        }
        return count;
    }

}
