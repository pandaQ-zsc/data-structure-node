package com.lee.asia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            Arrays.sort(s1);
            for (String a : s1) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    public static void main2(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        while ((line = bf.readLine()) != null) {
            String[] subStr = line.split(" ");

            Arrays.sort(subStr);

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < subStr.length; i++) {
                sb.append(subStr[i]).append(" ");
            }

            System.out.println(sb.toString().trim());
        }
    }
}
