package com.lee.asia;

import java.util.PriorityQueue;

/**
 * Author: xiong.qiang
 * Date: 2023/1/3 19:26
 */

//订单类型 orderTypei 可以分为两种：
//
//0 表示这是一批采购订单 buy
//1 表示这是一批销售订单 sell

//输入：orders = [[10,5,0],[15,2,1],[25,1,1],[30,4,0]]
//输出：6
public class _1801_积压订单中的订单总数 {
    public static int getNumberOfBacklogOrders1(int[][] orders) {
        PriorityQueue<Integer> buyQue = new PriorityQueue<>((i1, i2) -> orders[i2][0] - orders[i1][0]);
        PriorityQueue<Integer> sellQue = new PriorityQueue<>((i1, i2) -> orders[i1][0] - orders[i2][0]);
        for (int i = 0; i < orders.length; i++) {
            int[] o = orders[i];
            int type = o[2], price = o[0], count = o[1];
            // buy
            if (type == 0) {
                while (count > 0 && sellQue.size() > 0) {
                    //sell
                    int[] q = orders[sellQue.peek()];
                    if (q[0] > price) {
                        break;
                    }
                    int min = Math.min(o[1], q[1]);
                    o[1] -= min;
                    q[1] -= min;
                    if (q[1] == 0) {
                        sellQue.poll();
                    }
                }
                if (o[1] > 0) {
                    buyQue.offer(i);
                }
            } else {
                while (count > 0 && buyQue.size() > 0) {
                    // sell
                    int[] q = orders[buyQue.peek()];
                    if (q[0] < price) {
                        break;
                    }
                    int min = Math.min(o[1], q[1]);
                    o[1] -= min;
                    q[1] -= min;
                    if (q[1] == 0) {
                        buyQue.poll();
                    }
                }
                if (o[1] > 0) {
                    sellQue.offer(i);
                }
            }
        }
        int res = 0;
        for (int[] order : orders) {
            res += order[1];
        }
        return res;
    }

    public static int getNumberOfBacklogOrders(int[][] orders) {
        //大顶堆： 从大到校
        PriorityQueue<Integer> buyQue = new PriorityQueue<>((i1, i2) -> orders[i2][0] - orders[i1][0]);
        //小顶堆  从小到大
        PriorityQueue<Integer> sellQue = new PriorityQueue<>((i1, i2) -> orders[i1][0] - orders[i2][0]);
        for (int i = 0; i < orders.length; i++) {
            int[] o = orders[i];
            //o[1]:个数
            int type = o[2], price = o[0];
            if (type == 0) { // o是采购订单buy
                while (!sellQue.isEmpty() && o[1] > 0) {
                    int[] q = orders[sellQue.peek()];
                    if (q[0] > price) break;
                    int min = Math.min(o[1], q[1]);
                    o[1] -= min;
                    q[1] -= min;
                    if (q[1] == 0) sellQue.poll();
                }
                if (o[1] > 0) buyQue.offer(i);
            } else { // o是销售订单 sell
                while (!buyQue.isEmpty() && o[1] > 0) {
                    int[] q = orders[buyQue.peek()];
                    if (q[0] < price) break;
                    int min = Math.min(o[1], q[1]);
                    o[1] -= min;
                    q[1] -= min;
                    if (q[1] == 0) buyQue.poll();
                }
                if (o[1] > 0) sellQue.offer(i);
            }
        }

        int ret = 0;
        for (int[] o : orders) {
            ret = (ret + o[1]) % (1000000007);
        }
        return ret;
    }


    public static void main(String[] args) {
        int[][] tmp = new int[][]{{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}};
        int numberOfBacklogOrders = getNumberOfBacklogOrders(tmp);
        System.out.println(numberOfBacklogOrders);

        PriorityQueue<Integer> buyQue = new PriorityQueue<>((i1, i2) -> i1 - i2);
        buyQue.add(1);
        buyQue.add(2);
        buyQue.add(3);
        buyQue.add(31);
        buyQue.add(32);
        buyQue.add(31);
        buyQue.add(20);
        System.out.println(buyQue.toString());
        Integer poll = buyQue.poll();
        System.out.println(buyQue.toString());
        Integer poll2 = buyQue.poll();
        System.out.println(poll);
        System.out.println(buyQue.toString());
        System.out.println(poll2);
        System.out.println(buyQue.toString());


    }
}
