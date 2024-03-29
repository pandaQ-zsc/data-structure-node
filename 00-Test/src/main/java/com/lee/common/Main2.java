package com.lee.common;

import java.util.Scanner;

/*
 *
 * @作者：付修杨
 * @时间：2016年8月5日09:27:19
 * @功能：
 * 		题目描述：
			有股神吗？
			有，小赛就是！
			经过严密的计算，小赛买了一支股票，他知道从他买股票的那天开始，股票会有以下变化：第一天不变，以后涨一天，跌一天，涨两天，
			跌一天，涨三天，跌一天...依此类推。
			为方便计算，假设每次涨和跌皆为1，股票初始单价也为1，请计算买股票的第n天每股股票值多少钱？


		输入
			输入包括多组数据；
			每行输入一个n，1<=n<=10^9 。


		输出
			请输出他每股股票多少钱，对于每组数据，输出一行。


		问题解析：

		天     数：	1	2	3	4	5	6	7	8	9	10
		涨跌情况：	0	1	-1	1	1	-1	1	1	1	-1
                     n : 1  2  3
                     x : 3  6  10
		由题意可知：第n次跌是发生在第x天，x与n的关系为：
						x = n^2/2 +
						* 3n/2 + 1      n>=1;
					也可把公式转化为：
						n = （根号）(2x+0.25) - 1.5    x>=1;

 */

public class Main2 { //solution

    public static void main(String[] args) {
        //读取
        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
            int day = input.nextInt();
            int money  = cal_Money(day);
            System.out.println(money);
        }

    }
    public static int cal_Money(int day) {
        if(day == 1 ) return 1;
        if(day == 2 ) return 2;
        if(day == 3 ) return 1;

        int i =1;
        int sum;
        int money;
        while(true) {
            //(1+i)*i/2  1...i的累加
            if ( (1+i)*i/2 <=day ) {
                i++;
            }else {
                i--;
                sum = (1+i)*i/2;
                break;
            }
        }
        if(day == sum) {
            money = (1+(i-2))*(i-2)/2 +1 ;
        }else {
            money = (1+(i-2))*(i-2)/2 + (day-sum) +1;
        }
        return money;
    }
}

//
//public class Main2{
//    public static void main(String[] args) {
//        int date;
//        Scanner sc = new Scanner(System.in);
////		System.out.println("请输入天数n");
//        date = sc.nextInt();
//
//
//        //方法一：循环加，算法时间复杂度为O(n);
///*		int price = 1, priceDownDate = 3, priceDownNum = 1;
//		for(int i = 2; i <= date; i ++){
//			if(priceDownDate == i){
//				priceDownNum ++;
//				priceDownDate = (priceDownNum*priceDownNum + 3*priceDownNum)/2 + 1;
//				price --;
//			}else{
//				price ++;
//			}
//		}*/
//
//
//        //方法二：公式求，算法复杂度为1；
//        int price , priceDownNum;
//        priceDownNum = (int) (Math.sqrt(2*date + 0.25) - 1.5);
////		System.out.println(priceDownNum);
//        price = date - 2*priceDownNum;
//        System.out.println(price);
//
//    }
//}
