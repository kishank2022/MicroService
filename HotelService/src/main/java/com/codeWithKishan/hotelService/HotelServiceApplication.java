package com.codeWithKishan.hotelService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelServiceApplication {

	public static void main(String[] args) {
		System.out.println("Fire mode on ");
		System.out.println("Hotel 1 ");
		SpringApplication.run(HotelServiceApplication.class, args);
	}

}
