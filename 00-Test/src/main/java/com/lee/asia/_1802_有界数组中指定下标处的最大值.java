package com.lee.asia;


/**
 * Author: xiong.qiang
 * Date: 2023/1/4 17:21
 */

//给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：
//nums.length == n
//nums[i] 是 正整数 ，其中 0 <= i < n
//abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
//nums 中所有元素之和不超过 maxSum
//nums[index] 的值被 最大化
//返回你所构造的数组中的 nums[index] 。
//
//注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。
//
//示例 1：
//
//输入：n = 4, index = 2,  maxSum = 6
//输出：2
//解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。

//示例 2：
//
//输入：n = 6, index = 1,  maxSum = 10
//输出：3
//
//链接：https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array
public class _1802_有界数组中指定下标处的最大值 {


    //1 1 1 1
    //1 1 2 1  +1
    //1 2 3 2  +3 = +1 + 1(left) + 1(right)
    //2 3 4 3  +4 = +3 + 1(left) +0(right触及边界)
    //3 4 5 4  +4 = +4 + 0 + 0     : n个
    //4 5 6 5  +4 = +4 + 0 + 0     : n个
    //第一层和为n，第二层和+1，第三层+3，为上一层累加值interval加上左右扩展，以此类推，类加值interval达到n时无法扩，往下每层都是+n，所以interval达到n时可以直接除n取次数
    // inter
    public static int maxValue1(int n, int index, int maxSum) {
        //全部为1
        int sum = n;
        // n: 总共多少个
        // max:最高点索引index 每个阶段的高度。或者是：扩展的距离， 第一次是0  后面是 1 . 2. 3. 4  用于触边判断。
        // interval: 覆盖范围  初始为1。 加上旁边触边判断是否+1
        // sum : 循环中每次的总数
        int max = 0;
        int interval = 1;
        while (sum <= maxSum) {
            max++;
            if (interval == n) {
                // 如果方块超出了数组的左边界和右边界  说明数组中的所有数都必须参与运算了,就不用一次一次累加了，直接作一次除法即可
                return max + (maxSum - sum) / n;
            }
            sum += interval;
            //左边界  距离index最高点距离: index - max
            if (index - max >= 0) {
                interval++;
            }
            //右边界  距离index最高点距离: index + max
            if (index + max < n) {
                interval++;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int res = maxValue1(6, 1, 10);
        System.out.println(res);


    }
    //https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/solution/by-penciy-sv5w/
    //贪心算法：每次都让其是最小花销。
//    int maxValue3(int n, int index, int maxSum) {
//        // ans是最大化的nums[index]值，LowCost是想要得到ans，需要的数组和最小值(数组初始为全1)
//        int ans = 1, LowCost = n;
//        // 从当前状态转移到下一状态(ans+=1，且维持数组和最小)
//        while (LowCost <= maxSum) {
//            // 如果方块超出了数组的左边界和右边界  说明数组中的所有数都必须参与运算了,就不用一次一次累加了，直接作一次除法即可
//            if (index <= ans - 1 && n - index - 1 <= ans - 1) {
//                return (maxSum - LowCost) / n + ans;
//            }
//            LowCost += 1;     // index位置上的数+1
//            LowCost += min(ans - 1, index);   // index左边出现不满足绝对值差的数，将他们都+1
//            LowCost += min(ans - 1, n - index - 1);  // index右边的也+1
//            ans++;
//        }
//        return ans - 1;
//    }


}
