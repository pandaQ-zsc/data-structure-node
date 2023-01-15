package com.leecode.高频笔试题;

//映射  腾讯笔试题 ：求最大子序列数组
// https://blog.csdn.net/qq_41479464/article/details/88382513

//io相关
//https://blog.csdn.net/u011494298/article/details/108528331?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-2.no_search_link&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-2.no_search_link
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//FileInputStream来读取，完全没有问题，他是读取字节形式的，
// 所以读到中文字符的时候，字节流就会出现乱码，所以必去用要字符流来读取，
// 在用FileInputStream读取文件是用他里面read（）方法来读取的，
// 是一口气直接全部读完的，就会留下原来文件换行的脚印，
// 但是用BufferedReader来读取是用readLine（）来读取的，
// 意思是一行一行的来读取，这样当读到回车符的时候，就先返回给字符串， 然后再进行下一行的读取！
//首先System.in是向屏幕输入一些数据，
// new InputStreamReader()是输入流，可以用来读取数据
// new InputStreamReader(System.in)以System.in作为参数，创建InputStreamReader的对象，
// 就是读取屏幕上输入的数据，但这样读取不具有缓冲功能，所以用了BufferedReader这个类
// BufferedReader br=new BufferedReader(new InputStreamReader(System.in))
// 这一句的意思就是以InputStreamReader的对象作为参数，来创建BufferedReader的对象
// 这样br这个对象就代表了一个具有缓冲功能的输入流

////给定一个顺序存储的线性表，请设计一个算法查找该线性表中最长的连续递增子序列
//// 例如，(1,9,2,5,7,3,4,6,8,0)中最长的递增子序列为(3,4,6,8)。
//// 输入：
////  15
////   1 9 2 5 7 3 4 6 8 0 11 15 17 17 10
////   1 9 2 5 7 (3 4 6 8) 0 11 15 17 17 10
//// 输出： 3 4 6 8
public class _53_笔试dp_最大连续子数组和 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        List<Integer> list = maxSubArr(nums);
        String s = list.toString();
        System.out.println(maxSubArr(nums));
        System.out.println(s);
    }

    public static List<Integer> maxSubArr(int[] nums){
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        //nums:[-2, 1, -2, 4, 3, 5, 6, 1, 5]
        //dp[i][0] 每个index:累计的最大和
        //dp[i][1]:记录每个index下标 【start 初始位置】

        //    nums:[-2, 1, -2, 4, 3, 5, 6, 1, 5]
        //dp[i][0]:[-2, 1, -3, 4, -1, 2, 1, -5, 4]
        //dp[i][1]:[0,  1,  2, 3,  4, 5, 6, 7, 8]
        int[][] dp = new int[nums.length][2];
        for (int i = 0;i < nums.length;i++){
            dp[i][1] = i;
        }
        dp[0][0] = nums[0];
        int max = dp[0][0];
        int start = 0;
        int end = 0;
        for (int i = 1;i < dp.length;i++){
            if (dp[i - 1][0] > 0){
                dp[i][0] = dp[i - 1][0] + nums[i];
                dp[i][1] = dp[i - 1][1];
            }else {
                dp[i][0] = nums[i];
                dp[i][1] = i;
            }
            //如果目前已经累计最大值中的最大值了 就去找start和end
            max = Math.max(dp[i][0],max);
            if (max == dp[i][0]){
                start = dp[i][1];
                end = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = start;i <= end;i++){
            res.add(nums[i]);
        }
        return res;
    }
}
