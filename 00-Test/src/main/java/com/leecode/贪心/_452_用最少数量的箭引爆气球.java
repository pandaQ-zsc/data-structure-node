package com.leecode.贪心;

import java.util.Arrays;
import java.util.Comparator;

public class _452_用最少数量的箭引爆气球 {
//    贪心法, 每个气球只少需要一支箭, 先按照右端点排序, 然后每次
//    从最小的右端点射出一支箭, 去掉被射爆的气球, 重复该过程.

    //输入：points = [[10,16],[2,8],[1,6],[7,12]]
    //输出：2
    //解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球

    //sort 之后 points: [1,6] [2,8] [7,12] [10,16]

    public int findMinArrowShots(int[][] points) {
       if (points == null || points.length < 1) return 0;
//       Arrays.sort(points,(a,b)->{
           // return a[1]-b[1];
//           return  Integer.compare(a[1],b[1]);
//       });
        Arrays.sort(points,(a,b)-> a[1]>b[1] ? 1: -1);
       int count =1;
       int axis = points[0][1];
        for (int i = 1; i <points.length ; i++) {
            if ( axis < points[i][0]){
                count++;
                axis = points[i][1];
            }
        }
        return count;
    }
}
