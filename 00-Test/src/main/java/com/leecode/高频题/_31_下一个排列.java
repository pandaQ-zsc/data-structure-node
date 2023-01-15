package com.leecode.高频题;

import java.util.Arrays;

//https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
//在尽可能靠右的低位进行交换，需要从后向前查找
//将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，
// 下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
// 将「大数」换到前面后，需要将「大数」后面的所有数重置为升序，
// 升序排列就是最小的排列。以 123465 为例：首先按照上一步，
// 交换 5 和 4，得到 123564；然后需要将 5 之后的数重置为升序，
// 得到 123546。显然 123546 比 123564 更小，123546 就是 123465 的下一个排列
//
//   1238|57|64  的下一个排列就是 12386457。
//   1238|67|54
//   1238|6|457
//
//
//   从后往前找到第一个升序的元素对(i,j)--->就能确定[j,end)是降序的
//   然后在降序[j,end)区间从后往前找  第一个大于a[i]的值  然后跟[i]进行交换
//   交换后 ：对[j,end]的数进行升序。
//   1235|78|6
//   1235|87|6
//   1235|86|7
//
//   1238|57|64  的下一个排列就是 12386457。
//   1238|67|54
//   1238|6|457
public class _31_下一个排列 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n < 2) return; //特判
        int min = n - 1; //较大值中的最小值的下标初始化为n-1
        boolean flag = false; //用于判断是不是递减序列
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) { //从后往前遍历，遇到更小数就开始下一步
                while (nums[i - 1] >= nums[min]) {//while循环用于找到较大数中的最小数所在的索引min
                    min--;
                }
                change(nums, i - 1, min);//先交换，交换之后索引大于i-1的元素一定是降序的。
                reverse(nums, i);//再反转（从i开始）
                flag = true;//有交换就不是递减数组
                break;
            }
        }
        if (!flag) Arrays.sort(nums); //flag没变说明是递减数组，那就递增排nums
    }

    //交换位置i和j的值
    public void change(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //反转nums中start位置到最后部分
    public void reverse(int[] nums, int start) {
        int n = nums.length;
        int end = n - 1;
        while (end > start) {
            change(nums, start, end);
            end--;
            start++;
        }
    }

    //   1238|57|64  的下一个排列就是 12386457。
//   1238|67|54
//   1238|6|457
    public void nextPermutation2(int[] nums) {
        int len = nums.length;
        if (len <= 1) return;

        for (int i = len - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {            //找到相邻升序
                for (int j = len - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {    //找到最右边大于nums[i-1]的数，并交换
                        int tmp = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = tmp;
                        break;
                    }
                }
                Arrays.sort(nums, i, len);      //将后面降序变为升序
                return;
            }
        }
        Arrays.sort(nums);
    }
    //错误示范  if (nums[i] < nums[i - 1]) {
    //  123|65|87
    //  123|65|87
    //  123|75|86
    //  123|75|68

    //  1236|58|7
    //  1236|78|5
    //  1236|75|8
    //

    // 532 16
    // 532 61

    // 5 36 21
    // 5 61 23
    public void nextPermutation3(int[] nums) {
        int len  = nums.length;
        for (int i = len-1; i >0 ; i-- ) {
            if (nums[i] > nums[i-1]){
                for (int j = len-1; j>=i ; j--) {
                    if (nums[j] > nums[i-1]){
                        int tmp = nums[i-1];
                        nums[i-1] = nums[j];
                        nums[j] = tmp;
                        break;
                    }
                }
                Arrays.sort(nums,i,len);
                return;
            }
        }
        Arrays.sort(nums);
    }

}
