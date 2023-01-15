package com.单例;

import java.io.Serializable;
//https://blog.csdn.net/fly910905/article/details/79286680
//饿汉模式在类加载的时候就对实例进行创建，实例在整个程序周期都存在。
//它的好处是只在类加载的时候创建一次实例，不会存在多个线程创建多个实例的情况，避免了多线程同步的问题。
//它的缺点也很明显，即使这个单例没有用到也会被创建，而且在类加载之后就被创建，内存就被浪费了
//饿汉式
public class Singleton1 implements Serializable {
   private static final Singleton1 instance = new Singleton1();
   private Singleton1(){
       //预防反射创建另外一个对象 破坏单例
       if (instance != null) {
           throw new RuntimeException("单例对象不能重复创建");
       }
       System.out.println("private Singleton1()");
   }

   public static Singleton1 getInstance(){
       return instance;
   }
   public static void otherMethod(){
       System.out.println("otherMethod");
   }
   //防止被反序列化创建， 如果重写了readResolver  直接用这个方法返回INSTANCE
   // 防止字节数组反序列化创建对象
   public Object readResolver(){
       return instance;
   }

   // private static Singleton instance=new Singleton();// 自行创建实例
    //    private Singleton(){}// 构造函数
    //    public static Singleton getInstance(){// 通过该函数向整个系统提供实例
    //        return instance;
    //    }
    //
}

