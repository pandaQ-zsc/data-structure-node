package com.leecode.贪心;

public class _134_加油站 {
    //输入:
    //gas  = [1,2,3,4,5]
    //cost = [3,4,5,1,2]
    //
    //输出: 3
    //重点就两句话： 1、两个数组之差的总和必须大于等于0，否则不能完成绕行
    // 2、 一个站的收益如果小于0，肯定不能作为起点；而连续的多个站也可以等效地看做一个站，
    // 如果其累积收益小于0，就跳过，寻找下一个。
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        for (int i = 0; i < n; ++i) {
            //总和必须大于等于0，否则不能完成绕行
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            if (curr_tank < 0) {
                // 一个站的收益如果小于0，肯定不能作为起点；而连续的多个站也可以等效地看做一个站，
                // 如果其累积收益小于0，就跳过，寻找下一个。
                starting_station = i + 1;
                // 还原到初始状态
                curr_tank = 0;
            }
        }
        return total_tank >= 0 ? starting_station : -1;
    }

    //暴力
    //输入:
    //gas  = [1,2,3,4,5]
    //cost = [3,4,5,1,2]
    //
    //输出: 3
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            if (gas[i] < cost[i]) {
                continue;
            }
            int index = i;
            int left = gas[index] - cost[index];
            while (left + gas[(index + 1) % len] >= cost[(index + 1) % len]) {
                left += gas[(index + 1) % len] - cost[(index + 1) % len];
                index = (index + 1) % len;
                if (index == i) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int canCompleteCircuit3(int[] gas, int[] cost) {
      int len = gas.length;
        for (int i = 0; i < len; i++) {
            if (gas[i] < cost[i]) continue;
            int index= i;
            int left = gas[index]  - cost[index];
            while(left + gas[(index + 1) % len ] >= cost[(index+1) %len]){
                left = left + gas[(index + 1) % len ] - cost[(index+1) %len];
                index = (index + 1) % len ;
                if (index == i) return index;
            }
        }
        return -1;
    }
}