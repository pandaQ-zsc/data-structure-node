package com.leecode.高频笔试题;

//映射  腾讯笔试题 ：求最大子序列数组
// https://blog.csdn.net/qq_41479464/article/details/88382513

//io相关
//https://blog.csdn.net/u011494298/article/details/108528331?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-2.no_search_link&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-2.no_search_link
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class _53_笔试_最长连续递增子序和数组 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int[] res = new int[n];
//        String[] s = br.readLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            res[i] = Integer.parseInt(s[i]);
//        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] res = new int[n];
        String[] s1 = br.readLine().split(" ");
        //將s1转成 int[]的数组
        for (int i = 0; i < s1.length; i++) {
            res[i] = Integer.parseInt(s1[i]);
        }
        //最大子序列和的起点：ss
        //每次连续递增的起点 ：x
//        int max = 0,count = 0, ss= 0,x=0,y=0;
//        for (int i = 0; i < n - 1; i++) {
//            y =i+1;
//            //判断是否递增，是的话count++;
//            if (res[i+1]>res[i]){
//                count++;
//                if (count >max){
//                    max = count;
//                    ss= x;
//                }
//            }else {
//                count = 0 ;
//                //不连续递增，索引改变成下一个目标
//                x=y;
//            }
//        }
        int cur = 0 ;  int left = 0; int maxIdx=0,count=0,max=0;
        for (int i = 0; i < n-1; i++) {
            cur = i+1;
            if (res[i+1]>res[i]){
                count++;
                if (count > max){
                    max = count;
                    maxIdx = left;
                }
            }else {
                count = 0;
                left=  cur;
            }
        }
        for (int i = maxIdx; i <=  maxIdx + max; i++) {
            //i到达最末尾
            if (i == maxIdx+max){
                System.out.print(res[i]);
            }else {
                System.out.print(res[i]+" ");
            }
        }
    }
}
