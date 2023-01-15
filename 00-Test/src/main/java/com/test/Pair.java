package com.test;

/**
 * @author xiong.qiang
 * @date 2022/12/14 16:18
 */
public class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setLast(T last) {
        this.last = last;
    }

    // 对静态方法使用<T>:
    public static <K> Pair<K> create(K first, K last) {
        return new Pair<K>(first, last);
    }

    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);
    }

    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
//        p.setFirst(new Integer(first.intValue() + 100));
//        p.setLast(new Integer(last.intValue() + 100));
        return p.getFirst().intValue() + p.getFirst().intValue();

    }

}