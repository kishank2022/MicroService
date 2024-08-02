package com.codeWithKishan.hotelService.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeWithKishan.hotelService.entities.Hotel;
import com.codeWithKishan.hotelService.exception.ResourceNotFoundException;
import com.codeWithKishan.hotelService.repositories.HotelRepository;
import com.codeWithKishan.hotelService.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		String hotel_id = UUID.randomUUID().toString();
		hotel.setHotel_id(hotel_id);
		Hotel savedHotel = this.hotelRepository.save(hotel);
		return savedHotel;
	}

	@Override
	public Hotel getHotel(String hotel_id) {
		Hotel hotel1 = new Hotel();
		Optional<Hotel> hotel = this.hotelRepository.findById(hotel_id);
		if(hotel.isPresent()) {
			hotel1 = hotel.get();
		}
		return hotel1;

	}
	@Override
	public List<Hotel> getAllHotels() {
		List<Hotel> allHotels = this.hotelRepository.findAll();
		return allHotels;
	}

	@Override
	public Hotel updateHotel(Hotel hotel) {
		Hotel h1 = this.hotelRepository.findById(hotel.getHotel_id()).orElseThrow( 
				() -> new ResourceNotFoundException("Resource with this id is not found !! "));
		h1 = hotel;
		return h1;
	}

	@Override
	public String deleteHotel(String hotel_id) {
		Hotel h1 = this.hotelRepository.findById(hotel_id).orElseThrow( 
				() -> new ResourceNotFoundException("Resource with this id is not found !! "));
		this.hotelRepository.deleteById(hotel_id);
		return " Hotel details deleted successfully !!!";
	}

}
