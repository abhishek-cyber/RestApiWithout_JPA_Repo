package com.abhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiWithoutJpaRepoApplication {

	public static void main(String[] args) {
		System.out.println("Application Started...!");
		SpringApplication.run(RestApiWithoutJpaRepoApplication.class, args);
	}

}
