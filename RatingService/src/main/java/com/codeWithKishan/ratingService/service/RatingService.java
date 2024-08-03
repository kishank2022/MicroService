package com.codeWithKishan.ratingService.service;

import java.util.List;

import com.codeWithKishan.ratingService.entities.Rating;

public interface RatingService {

	
	// create 
	Rating createRating(Rating rating);
	
	// getAll ratings 
	List<Rating> getAllRatings();
	
	// get All ratings by userId
	List<Rating> getRatingByUserId(String userId);
	
	// get All ratings by hotelId 
	List<Rating> getRatingByHotelId(String hotelId);
	
	// get single rating 
	Rating getRating(String ratingId);
	
	// delete rating 
	String deleteRating(String ratingId);
	
	// update rating 
	Rating updateRating(Rating rating);
	
	
}
