package com.codeWithKishan.hotelService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeWithKishan.hotelService.entities.Hotel;
import com.codeWithKishan.hotelService.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	// create hotel
	@PostMapping("/")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel hotel1 = this.hotelService.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
	}
	
	// get Single Hotel
	// get hotel by id 
	@GetMapping("/{hotel_id}")
	public ResponseEntity<Hotel> getHotelDetails(@PathVariable String hotel_id){
		Hotel hotel1 = this.hotelService.getHotel(hotel_id);
		return new ResponseEntity<Hotel>(hotel1,HttpStatus.OK);
	}
	
	// get All hotel details 
	@GetMapping("/")
	public ResponseEntity<List<Hotel>> getAllHotels(){
		List<Hotel> hotels = this.hotelService.getAllHotels();
		return ResponseEntity.status(HttpStatus.OK).body(hotels);
	}
	
	@PutMapping("/")
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel)
	{
		Hotel updatedHotel = this.hotelService.updateHotel(hotel);
		return new ResponseEntity<Hotel>(updatedHotel, HttpStatus.OK);
	}
	
	@DeleteMapping("/{hotel_id}")
	public ResponseEntity<String> deleteHotelById(@PathVariable String hotel_id){
		String result = this.hotelService.deleteHotel(hotel_id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
