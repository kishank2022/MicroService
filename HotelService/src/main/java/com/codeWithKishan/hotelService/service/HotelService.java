package com.codeWithKishan.hotelService.service;

import java.util.List;

import com.codeWithKishan.hotelService.entities.Hotel;

public interface HotelService {

	// create hotels
	Hotel createHotel(Hotel hotel);
	
	// Get single Hotel
	Hotel getHotel(String hotel_id);
	
	// get all hotels
	List<Hotel> getAllHotels();
	
	// update hotel
	Hotel updateHotel(Hotel hotel);
	
	// delete hotel
	String deleteHotel(String hotel_id);
	
	
	
}
