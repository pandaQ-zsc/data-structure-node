package com.lee.asia;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: xiong.qiang
 * @date: 2023/5/10 14:50
 */
public class _1_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i < nums.length ; i++){
            if (map.containsKey(target -nums[i])){
                return new int[]{map.get(target-nums[i]) , i};

            }else {
                map.put(nums[i],i);
            }
        }
        return new int[]{};
    }

    //Input: nums = [2,7,11,15], target = 9
    //Output: [0,1]
    //Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    //
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 26);
        System.out.println(Arrays.toString(ints));
     }
}
