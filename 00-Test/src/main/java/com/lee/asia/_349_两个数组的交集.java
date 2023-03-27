package com.lee.asia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: xiong.qiang
 * Date: 2022/12/30 15:13
 */
///给定两个数组nums1和nums2 ，返回 它们的交集。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
//

//
//示例 1：
//
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
//
//链接：https://leetcode.cn/problems/intersection-of-two-arrays
public class _349_两个数组的交集 {

    private static String regex;

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> resSet = new HashSet<>();
        HashSet<Integer> filterSet = new HashSet<>();
        for (int n : nums1) {
            filterSet.add(n);
        }
        for (int n : nums2) {
            if (filterSet.contains(n)) {
                resSet.add(n);
            }
        }
//        return resSet.stream().mapToInt(x -> x).toArray();
        int index = 0;
        int[] res = new int[resSet.size()];
        for (int item : resSet) {
            res[index++] = item;
        }
        return res;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i : nums1) {
            list1.add(i);
        }
        for (int i : nums2) {
            list2.add(i);
        }
        int[] res = list1.stream().filter(list2::contains).mapToInt(e -> e).distinct().toArray();
        return res;
    }

    ;

    public static void main(String[] args) {
        int[] intersection = intersection(new int[]{1, 2, 3, 1}, new int[]{2, 3, 4, 2});
        for (int i : intersection) {
            System.out.println(i);
        }

        String str = "abcd324232efg";
        regex = "([a-z]*)(\\d*)([a-z]*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }
        System.out.println("==================");
        final String regex = "(?: ?\\G|^cats are )((?:silly|cute)(?: |$))";
        final String string = "cats are silly cute and cute";

//        final Pattern pattern = Pattern.compile(regex);
//        final Matcher matcher = pattern.matcher(string);
//
        if (matcher.find()) {
            System.out.println("完整匹配: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("组 " + i + ": " + matcher.group(i));
            }
        }
    }
}
