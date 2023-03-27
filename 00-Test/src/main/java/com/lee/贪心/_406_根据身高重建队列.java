package com.lee.贪心;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _406_根据身高重建队列 {
    //先按照身高H从高到低排序，矮的人放在后面，这样在排队时不会对前面已经排好的队伍产生影响（因为数组中记录的是身高大于等于自己的人，身高小于自己的不管放在自己前面和后面都不会有影响）；
    //如果有身高相同的人，那么就要按照K从小到大排序，因为K小的肯定会排在K大的前面（具体原因可以用反证法来证明：假设有[hi, ki], [hj, kj]，且hi=hj,ki<kj，如果hj在hi的前面，那么ki>=kj+1成立，+1的原因是hi前面有hj。 => 矛盾，假设不成立，hi肯定在hj的前面）。
    //https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/406du-shuo-shi-tan-xin-na-yao-wei-shi-yao-yong-tan/
    //每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi
    // 前面 正好 有 ki 个身高大于或等于 hi 的人。
    //输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
    //输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
    //
    //sort : {7,0}{7,1}{6,1}{5,0}{5,2}{4,4}
    //回归本题，整个插入过程如下：
    //
    //排序完的people：
    //[[7,0], [7,1], [6,1], [5,0], [5,2]，[4,4]]
    //
    //插入的过程：
    //插入[7,0]：[[7,0]]
    //插入[7,1]：[[7,0],[7,1]]
    //插入[6,1]：[[7,0],[6,1],[7,1]]
    //插入[5,0]：[[5,0],[7,0],[6,1],[7,1]]
    //插入[5,2]：[[5,0],[7,0],[5,2],[6,1],[7,1]]
    //插入[4,4]：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
    //
    //此时就按照题目的要求完成了重新排列。
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{
            if (a[0] != b[0]){
                return b[0] - a[0];
            }else {
                return a[1] - b[1];
            }
        });
        List<int[]> list = new LinkedList<>();
        for(int[] p : people){
            list.add(p[1],p);
        }
        return list.toArray(new int[list.size()][2]);


    }
}
