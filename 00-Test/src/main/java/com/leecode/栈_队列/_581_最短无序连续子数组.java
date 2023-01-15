package com.leecode.栈_队列;

import java.util.Arrays;

//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _581_最短无序连续子数组 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int [] sort = nums.clone();
        Arrays.sort(sort);
        int i= 0 , j = n -1;
        while(i <= j && nums[i] == sort[i]) i++;
        while(j >= i && nums[j] == sort[j]) j--;
        return  j - i +1;
    }
}
