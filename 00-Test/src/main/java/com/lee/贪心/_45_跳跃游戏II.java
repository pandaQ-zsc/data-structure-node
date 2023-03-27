package com.lee.贪心;

public class _45_跳跃游戏II {
//输入: nums = [2,3,0,1,4]
//输出: 2
    public static int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        //记录跳跃的次数
        int count=0;
        //当前的覆盖最大区域
        int curDistance = 0;
        //最大的覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新最大的覆盖区域
            maxDistance = Math.max(maxDistance,i+nums[i]);
            //说明当前一步，再跳一步就到达了末尾
            if (maxDistance>=nums.length-1){
                count++;
                break;
            }
            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i==curDistance){//已经走到了当前跳跃步数的边界，
                count++; //跳一次
                //记录当前跳跃部署能到的最远距离
                curDistance = maxDistance;
            }
        }
        return count;
    }
////输入: nums = [2,3,0,1,4]
////输出: 2
    public static int jump2(int[] nums) {
        if (nums== null || nums.length ==0 || nums.length ==1){
            return 0;
        }
        int max= 0;
        int cur = 0;
        int count = 0;
        for (int i = 0; i <nums.length ; i++) {
            max = Math.max(max,nums[i]+i);
            if (max >= nums.length-1){
                count++;
                return count;
            }
            if (i == cur){
                count++;
                cur = max;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int jump = jump2(new int[]{2, 2, 1, 1, 4});
        System.out.println(jump);
    }
}

