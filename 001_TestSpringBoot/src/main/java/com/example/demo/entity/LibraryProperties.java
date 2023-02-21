package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by XQ on 2021/11/6.
 */
//使用这个@ConfigurationProperties(prefix = "library")需要导入依赖
// <dependency>
//			<groupId> org.springframework.boot </groupId>
//			<artifactId> spring-boot-configuration-processor </artifactId>
//			<optional> true </optional>
//		</dependency>
@Component
@ConfigurationProperties(prefix = "library")
@Getter
@Setter
@ToString
public class LibraryProperties {
    private String location;
    private List<Book> books;


    @Getter
    @Setter
    @ToString
    static class Book {
        String name;
        String description;
    }
}