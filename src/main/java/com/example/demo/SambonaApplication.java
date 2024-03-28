package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.demo"})
public class SambonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SambonaApplication.class, args);
		System.out.println("server started");
		System.out.println("server is runnng on localhost:8080/");

	}

}
