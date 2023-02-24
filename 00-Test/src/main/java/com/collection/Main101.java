package com.collection;

import com.enums.EnumTestDemo01;
import com.test.Employee;
import com.test.EmployeeData;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Scanner;

public class Main101 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        int i = 0;
        int count = 0;
        List<Employee> employees = EmployeeData.getEmployees();
        Employee xq = new Employee(0, "xq", 18, 20000);
        Class<?> aClass = Class.forName("com.test.Employee");
        //private:
        try {
            Field name = aClass.getDeclaredField("name");
            name.setAccessible(true);
            System.out.println(name.get(xq));
            System.out.println(name);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException("异常");
        }
        //public:
        Field[] fields = aClass.getFields();
        System.out.println("===========");
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("===========");
        Object o = aClass.newInstance();
        System.out.println(o.toString());
        Integer status = EnumTestDemo01.SINGLE.getValue();
        while (i != 3) {
            Scanner scanner = new Scanner(System.in);
            i = scanner.nextInt();
            String s = multiSwitch(i);
            System.out.println(s);
            count ++;
        }

    }

    public static String multiSwitch(int select) {
        switch (select) {
            case 1:
                return "单人模式";
            case 2:
                return "多人模式";
            case 3:
                return "退出游戏";
            default:
                return "请输入 【1、2、3】";
        }
    }

}
