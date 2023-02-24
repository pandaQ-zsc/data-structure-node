package com.example.demo.entity;

import lombok.Data;

/**
 * @author xxx
 */
@Data
public class Student {
    String stuNum;
    String name;
    int age;

    public Student() {
    }

    public Student(int age) {
        this.age = age;
        System.out.println(age + "stu");
    }

    public Student(String stuNum, String name, int age) {
        this.stuNum = stuNum;
        this.name = name;
        this.age = age;
    }

}
