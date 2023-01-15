package com.collection;

import java.util.HashSet;

public class Main101 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        set.add(2);
        set.add(3);
        set.add(12);
        System.out.println(set);
    }
}
