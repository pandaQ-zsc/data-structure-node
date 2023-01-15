package com.mj;

/**
 * @author xxx
 */
public class CharSequenceTest {

    public static void main(String[] args) {
        testCharSequence();
    }

    /**
     * CharSequence 测试程序
     */
    private static void testCharSequence() {
        System.out.println("-------------------------------- testCharSequence -----------------------------");

        // 1. CharSequence的子类String
        String str = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("1. String");
        System.out.printf("   %-30s=%d\n", "str.length()", str.length());
        System.out.printf("   %-30s=%c\n", "str.charAt(5)", str.charAt(5));
        String substr = (String) str.subSequence(0, 5);
        System.out.printf("   %-30s=%s\n", "str.subSequence(0,5)", substr.toString());

        // 2. CharSequence的子类StringBuilder
        StringBuilder strbuilder = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
        System.out.println("2. StringBuilder");
        System.out.printf("   %-30s=%d\n", "strbuilder.length()", strbuilder.length());
        System.out.printf("   %-30s=%c\n", "strbuilder.charAt(5)", strbuilder.charAt(5));
        // 注意：StringBuilder的subSequence()返回的是，实际上是一个String对象！
        String substrbuilder = (String) strbuilder.subSequence(0, 5);
        System.out.printf("   %-30s=%s\n", "strbuilder.subSequence(0,5)", substrbuilder.toString());

        // 3. CharSequence的子类StringBuffer
        StringBuffer strbuffer = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
        System.out.println("3. StringBuffer");
        System.out.printf("   %-30s=%d\n", "strbuffer.length()", strbuffer.length());
        System.out.printf("   %-30s=%c\n", "strbuffer.charAt(5)", strbuffer.charAt(5));
        // 注意：StringBuffer的subSequence()返回的是，实际上是一个String对象！
        String substrbuffer = (String) strbuffer.subSequence(0, 5);
        System.out.printf("   %-30s=%s\n", "strbuffer.subSequence(0,5)", substrbuffer.toString());

        System.out.println();
    }
}