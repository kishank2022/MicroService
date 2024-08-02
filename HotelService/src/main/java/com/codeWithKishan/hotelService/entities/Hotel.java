package com.codeWithKishan.hotelService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {

	public String getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getHotel_location() {
		return hotel_location;
	}

	public void setHotel_location(String hotel_location) {
		this.hotel_location = hotel_location;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@Id
	private String hotel_id;
	
	private String hotel_name;
	
	private String hotel_location;
	
	private String about;
	
	
}
