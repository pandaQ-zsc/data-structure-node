package com.mj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by XQ
 * 2021/11/10
 */
public class Test11 {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(13);
        list.add(1);
        String s = list.toString();
        System.out.println(s);
    }


}
