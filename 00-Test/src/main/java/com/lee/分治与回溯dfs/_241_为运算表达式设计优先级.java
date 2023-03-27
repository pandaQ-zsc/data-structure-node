package com.lee.分治与回溯dfs;

import java.util.ArrayList;
import java.util.List;

public class _241_为运算表达式设计优先级 {
    //输入: "2-1-1"
    //输出: [0, 2]
    //输入: "2*3-4*5"
    //输出: [-34, -14, -10, -10, 10]
    //解释:
    //(2*(3-(4*5))) = -34
    //((2*3)-(4*5)) = -14
    //((2*(3-4))*5) = -10
    //(2*((3-4)*5)) = -10
    //(((2*3)-4)*5) = 10
    //
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            //只有在遇到 + - * 的时候才进行分割计算
            if (c == '+' || c == '-' || c == '*') {
                // substring  是[)
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        //只有数字没有符号的情况
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }

    public List<Integer> diffWaysToCompute2(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '*' || c == '-') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                res.add(l + r);
                                break;
                            case '*':
                                res.add(l * r);
                                break;
                            case '-':
                                res.add(l - r);
                                break;
                        }
                    }
                }
            }
        }
        //此时说明没有组合
        if (res.size() == 0) {
            Integer integer = Integer.valueOf(input);
            res.add(integer);
        }
        return res;
    }

}
