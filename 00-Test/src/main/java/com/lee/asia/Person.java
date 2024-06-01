package com.lee.asia;

/**
 * @author xxx
 */
public class Person {
    public static int count = 0; // 静态属性
    public String name;

    public Person(String name) {
        this.name = name;
        count++; // 每创建一个实例，count增加
    }

    public static void main(String[] args) {
        Person p1 = new Person("Alice");
        Person p2 = new Person("Bob");
        // 输出 2
        System.out.println(Person.count);
        System.out.println(p1.count);
        System.out.println(p2.count);
    }
}

