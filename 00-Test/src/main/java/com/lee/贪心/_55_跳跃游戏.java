package com.lee.贪心;

//输入：nums = [2,3,1,1,4]
//输出：true
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
public class _55_跳跃游戏 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return  true;
        int range = nums[0];
        for (int i = 0; i <=range ; i++) {
            range = Math.max(range,i + nums[i]);
            if (range >= nums.length -1 ){
                return true;
            }
        }
        return false;
    }

    public boolean canJump2(int[] nums) {
        int maxposit = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxposit) return false;//若当前位置大于最远可达位置，直接返回false。
            maxposit = Math.max(maxposit, i + nums[i]);//记录当前可达最远位置。
        }
        return true;//遍历完都没找到不可达位置，那就可达呗。
    }
    public boolean canJump3(int[] nums) {
        if (nums.length == 1){
            return true;
        }
        int range = nums[0];
        for (int i = 0; i <= range; i++) {
            range = Math.max(nums[i] + i,range);
            if (range >=nums.length-1) return true;
        }
        return false;
    }
}
