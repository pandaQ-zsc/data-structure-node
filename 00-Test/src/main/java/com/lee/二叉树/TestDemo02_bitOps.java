package com.lee.二叉树;

/**
 * @author: xiong.qiang
 * @date: 2023/6/13 17:41
 */
public class TestDemo02_bitOps {


    public static int add(int num1, int num2) {
        int a = num1 ^ num2;
        int b = num1 & num2;
        b = b << 1;
        if (b == 0) {
            return a;
        } else {
            return add(a, b);
        }
    }

    public static int add2(int num1, int num2){
        int a = num1 ^ num2;
        int b = num1 & num2;
        if (b == 0){
            return a;
        }else {
            return add(a,b<<1);
        }
    }

    public static int numberOf1(int n) {
        int count = 0;
        //int 31位
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    //0和任意数字进行异或操作结果为数字本身.
    //两个相同的数字进行异或的结果为0.

    public static int singleNumber(int[] nums) {
        int value = 0;
        for (int num : nums) {
            value ^= num;
        }
        return value;
    }


    //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
    //
    //说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
    public static int singleNumber2(int[] nums) {
        int value = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    count++;
                }
            }
            if (count % 3 == 1) {
                value += (1 << i);
            }
        }
        return value;
    }

    public static int singleNumber3(int[] nums) {
        int value = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for(int num: nums){
                if (((num>>i)&1)==1){
                    count++;
                }
            }
            if (count%3 == 1){
                value += (1<<i);
            }
        }
        return value;
    }


    public static void main(String[] args) {
        System.out.println(add(4, 7));
        System.out.println(add2(4, 7));
        System.out.println(numberOf1(7));
        System.out.println(singleNumber(new int[]{2, 4, 3, 3, 4, 6, 2}));
        System.out.println(singleNumber2(new int[]{2, 2, 2, 4, 4, 4, 1}));
    }
}
