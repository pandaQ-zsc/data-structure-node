package com.lee.asia;

import java.util.*;

/**
 * @author Xiong Qiang
 * @date 2024/6/2 09:15
 */

public class _575_分糖果 {
    //找到唯一元素数量的另一种方法是遍历给定 candies 数组的所有元素，并继续将元素放入集合中。
    // 通过集合的属性，它将只包含唯一的元素。最后，我们可以计算集合中元素的数量，例如 count。要返回的值将再次由
    // min(count,n/2) 给出，如前面的方法所述。其中 n 表示 candies数组的大小。
    public static int distributeCandies(int[] candyType) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int candy : candyType){
            set.add(candy);
        }
        res = Math.min(candyType.length/2,set.size());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(distributeCandies(new int[]{1, 1, 2, 3}));

    }

}



