package com.ibm.bootcamp.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.ibm.bootcamp.property_management", "com.ibm.bootcamp.dao", "com.ibm.bootcamp.property_search", "com.ibm.bootcamp.authentication", "com.ibm.bootcamp.user_profile"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
}
