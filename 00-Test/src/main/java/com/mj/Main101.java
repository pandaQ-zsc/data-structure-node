package com.mj;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author xxx
 */
public class Main101 {
    public static void main(String[] args) {

    }

    @Test
    public void test2() {

        int i = 10 / 0;
        System.out.println(i);
    }

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
// 1 3
        list.stream().filter(x -> x % 2 == 1).forEach(System.out::println);
// 3 4
        list.stream().skip(2).forEach(System.out::println);

        List<String> listStr = Arrays.asList("123", "232", "554");
        Stream<Character> characterStream = listStr.stream().flatMap(Main101::fromStringToStream);
        System.out.println(">>" + characterStream);
        Stream<Integer> integerStream = list.stream().filter(e -> e > 2);
        List<Integer> collect = integerStream.collect(Collectors.toList());
        System.out.println(collect);
        IntStream.range(0, 3).map(i -> 3).forEachOrdered(System.out::println);

    }

    public static Stream<Character> fromStringToStream(String str) {//aa
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
}
