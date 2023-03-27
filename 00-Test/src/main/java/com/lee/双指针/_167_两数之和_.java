package com.lee.双指针;

public class _167_两数之和_ {
    //输入：numbers = [2,7,11,15], target = 9
    //输出：[1,2]
    //解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
    //
    public static int[] twoSum(int[] numbers, int target) {
        int l = 0 ; int r = numbers.length-1;
        while(l < r){
            if (numbers[l] + numbers[r] == target){
                return  new int[] {l+1,r+1};
            }else if (numbers[l] + numbers[r]  <target){
                l++;
            }else {
                r--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int a : ints) {
            System.out.print(a + "_");
        }
    }
}
