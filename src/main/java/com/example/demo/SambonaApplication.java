package com.example.demo;

//import com.example.demo.controllers.DataBase_init;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.demo"})
public class SambonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SambonaApplication.class, args);
//		DataBase_init.Init();
		System.out.println("server started");
		System.out.println("server is runnng on www.localhost:8080/");

	}

}
