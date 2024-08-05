package com.codeWithKishan.ratingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RatingServiceApplication {

	public static void main(String[] args) {
		System.out.println("Rating service fire mode on ");
		SpringApplication.run(RatingServiceApplication.class, args);
	}

}
