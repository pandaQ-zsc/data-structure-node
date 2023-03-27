package com.lee.asia;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _252_会议室 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (m1, m2) -> m1[0] - m2[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        heap.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= heap.peek()) {
                heap.remove();
            }
            heap.add(intervals[i][1]);
        }
        return heap.size();
    }
}
