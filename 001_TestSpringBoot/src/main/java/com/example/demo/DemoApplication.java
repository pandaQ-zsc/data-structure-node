package com.example.demo;

import com.example.demo.entity.LibraryProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xxx
 */
@SpringBootApplication
@MapperScan("com.example.demo.**.mapper")
public class DemoApplication implements InitializingBean {

    private final LibraryProperties libraryProperties;

    public DemoApplication(LibraryProperties libraryProperties) {
        this.libraryProperties = libraryProperties;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
//        Runnable runnable = () -> {
//            while (true) {
//                System.out.println("等待1....");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        Thread thread = new Thread(runnable);
//        thread.start();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(libraryProperties.getLocation());
        System.out.println(libraryProperties.getBooks());
    }
}
