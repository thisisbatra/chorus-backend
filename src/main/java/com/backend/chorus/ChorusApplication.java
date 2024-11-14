package com.backend.chorus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChorusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChorusApplication.class, args);
		System.out.println("chorus is running!");
	}

}
