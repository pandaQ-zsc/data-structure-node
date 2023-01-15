package com.单例;

public class Resource {
    //https://www.runoob.com/java/java-enum.html
    //https://blog.csdn.net/fly910905/article/details/79286680
   private Resource(){};
   enum Singleton{
       INSTANCE;
       private final Resource instance;
       Singleton(){
           instance = new Resource();
       }
       private Resource getInstance(){
           return instance;
       }
   }
   public static Resource getInstance(){
       return Singleton.INSTANCE.getInstance();
   }

    public static void main(String[] args) {
        Resource instance1 = Resource.getInstance();
        Resource instance2 = Resource.getInstance();
        System.out.println(" = "+(instance1 == instance2));
    }
}
