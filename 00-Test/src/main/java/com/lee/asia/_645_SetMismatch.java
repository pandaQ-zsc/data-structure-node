package com.lee.asia;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: xiong.qiang
 * @date: 2023/5/18 17:15
 */
public class _645_SetMismatch {

    //java 对于找出连续数出现的各种奇怪的场景，数组桶永远是好的选择

    public  static int[] findErrorNums2(int[] nums) {
        int a=0,b=0;
        int[] res = new int[nums.length+1];
        for(int num : nums){
            res[num]++;
        }
        for (int i = 1; i < res.length; i++) {
            if (res[i] ==2){
                a = i;
            }else if(res[i] ==0){
                b = i;
            }
        }
        return new int[]{a,b};
    }

    public  static int[] findErrorNums3(int[] nums) {
        int a=0,b=0;
         int[] arr = new int[nums.length+1];
         for(int num : nums){
             arr[num]++;
         }
        for (int i = 1; i <arr.length; i++) {
            if (arr[i] == 2){
                a = i;
            }
            if (arr[i] == 0){
                b=i;
            }
        }
        return  new int[]{a,b};

    }


    //inefficient   poor efficiency
    public  static int[] findErrorNums(int[] nums) {
        int a=0,b=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int i=1;i<=nums.length;i++){
            if (map.getOrDefault(i,0) ==2 ){
                a = i;
            }else if (map.getOrDefault(i,0) ==0){
                b = i;
            }
        }
        return new int[]{a,b};


    }



    //error
    // [3,2,3,4,6,5]
    //输出：
    //[3,2]
    //预期结果：
    //[3,1]
    public  static int[] findErrorNums1(int[] nums) {
        int repeat = 0;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i+1] == nums[i]){
                repeat = nums[i];
            }
        }
        int count =1;
        int[] tmpArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmpArr[i] = count++;
        }
        for (int i = nums[0]; i < nums.length; i++) {
            if (tmpArr[i] != nums[i]){
                res = tmpArr[i];
            }
        }
        return new int[]{repeat,res};

    }
//Example 2:
//Input: nums = [1,1]
//Output: [1,2]

//Input: nums = [2,2]
//Output: [2,1]

    //输入：
    //[3,2,2]
    //输出：
    //[2,3]
    //预期结果：
    //[2,1]

    public static void main(String[] args) {
        int[] res = new int[]{1,2,2,4};
//        int[] res2 = new int[]{1,1};
        System.out.println(Arrays.toString(findErrorNums2(res)));
//        System.out.println(Arrays.toString(findErrorNums(res2)));
    }
}
