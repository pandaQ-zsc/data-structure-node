package com.example.demo;

import com.example.demo.entity.LibraryProperties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  DemoApplication implements InitializingBean {

	private final LibraryProperties libraryProperties;

	public DemoApplication(LibraryProperties libraryProperties) {
		this.libraryProperties = libraryProperties;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(libraryProperties.getLocation());
		System.out.println(libraryProperties.getBooks());
	}
}
