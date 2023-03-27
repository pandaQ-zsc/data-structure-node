package com.lee.贪心;

import java.util.*;

//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

//输入：
//[[1,4],[5,6]]
//输出：
//[[5,6]]
//预期结果：
//[[1,4],[5,6]]
//排序 + 双指针
public class _56_合并区间 {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int left = intervals[0][0], right = intervals[0][1]; // 令第一个区间为头区间
        for (int i = 1; i < intervals.length; i++) {
            // 如果下一个区间在头区间右侧且无交集
            if (intervals[i][0] > right) {
                list.add(new int[]{left, right}); // 将头区间放入list
                left = intervals[i][0]; // 更新头区间为当前区间
                right = intervals[i][1];
            } else { // 如果有交集，更新头区间为原头区间和当前区间两个区间的并集
                left = Math.min(left, intervals[i][0]);
                right = Math.max(right, intervals[i][1]);
            }
            // 如果到了最后一个区间，将最后的头区间值加入
            if (i == intervals.length - 1) list.add(new int[]{left, right});
        }

        return list.toArray(new int[list.size()][]);
    }

    public static int[][] merge2(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> list = new LinkedList<>();
        int l = intervals[0][0],r=intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > r){
                list.add(new int[]{l,r});
                l = intervals[i][0];
                r = intervals[i][1];
            }else {
                l = Math.min(l,intervals[i][0]);
                r = Math.max(r,intervals[i][1]);
            }
            if (i == intervals.length-1){
                list.add(new int[]{l,r});
            }
        }
        return list.toArray(new int[list.size()][]);
    }


    public static void main(String[] args) {
        merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }
}
