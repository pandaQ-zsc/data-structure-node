package com.lee.贪心;

public class _376_摆动序列 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        int up = 1;
        int down =1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]){
                up = down + 1;
            }
            if (nums[i] < nums[i-1]){
                down = up +1;
            }
        }
        return  Math.max(up,down);
    }
    //输入：nums = [1,7,4,9,2,5]
    //输出：6
    public int wiggleMaxLength2(int[] nums) {
        if (nums.length < 2){
            return nums.length;
        }
        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            //得到当前差值
            curDiff = nums[i] - nums[i - 1];
            //如果当前差值和上一个差值为一正一负
            //等于0的情况表示初始时的preDiff
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
}
