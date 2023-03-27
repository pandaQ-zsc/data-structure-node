package com.lee.高频笔试题;

import java.util.*;

//https://www.nowcoder.com/questionTerminal/9cf027bf54714ad889d4f30ff0ae5481?f=discussion
public class _300_最长递增子序列_子序列 {

    /**
     * retrun the longest increasing subsequence
     *
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public static int[] LIS(int[] arr) {
        // write code here
        //思路 ： 记录下每一个位置能达到的最长值 并且维护一个放最长值的集合
        int[] maxLength = new int[arr.length];
        //放最长值的集合
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                maxLength[i] = 1;
                temp.add(arr[i]);
            } else {
                //如果当前的数比集合中最后一个数大 那正好满足递增数列要求 放上即可
                if (arr[i] > temp.get(temp.size() - 1)) {
                    temp.add(arr[i]);
                    //当前位置能达到的最长递增子序列的长度就是当前集合的size
                    maxLength[i] = temp.size();
                } else {
                    //不满足就替换队列中从左到右第一个比它大或者相等的值 这里不太好理解，为啥不把比它大或者相等的都舍弃？
                    //因为要保持当前最大长度不变 因为后面可能还有更大的数让这个集合变的更长，最终集合里的数并不是
                    //要返回的结果 它只是维护了一个最大长度而已,所以里面放的数不必太在意
                    for (int j = 0; j < temp.size(); j++) {
                        if (temp.get(j) >= arr[i]) {
                            temp.set(j, arr[i]);
                            maxLength[i] = j + 1;
                            break;
                        }
                    }
                }
            }
        }
        //思路 ： 记录下每一个位置能达到的最长值 并且维护一个放最长值的集合
        //length  = 9
        // 2 1 5 3 6 4 8 9 7     -- 13489
        //前面有多少個比当前值小的数
        // 1 1 2 2 3 3 4 5 4
        //tmp:
        // 1 3 4 7 9
        //遍历完后 每个位置能达到的最长值都有了 依次找出来吧 要从后往前找 想想[1,2,8,6,4] 是124 不是126你就明白了
        int max = temp.size();
        int[] res = new int[max];
        int curIndex = maxLength.length - 1;
        for (int i = max; i > 0; i--) {
            for (int j = curIndex; j >= 0; j--) {
                if (maxLength[j] == i) {
                    //从对应位置拿出整整的值
                    res[i - 1] = arr[j];
                    curIndex = j - 1;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] lis = LIS(new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7});
        System.out.println(Arrays.toString(lis));
    }
}
