package com.codeWithKishan.ratingService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeWithKishan.ratingService.entities.Rating;
import com.codeWithKishan.ratingService.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	// create
	@PostMapping("/")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		Rating createdRating = this.ratingService.createRating(rating);
		return new ResponseEntity<Rating>(createdRating, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Rating>> getAllRatings(){
		List<Rating> ratings = this.ratingService.getAllRatings();
		return ResponseEntity.status(HttpStatus.OK).body(ratings);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		List<Rating> ratings = this.ratingService.getRatingByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(ratings);
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		List<Rating> ratings = this.ratingService.getRatingByUserId(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(ratings);
	}
	
	@GetMapping("/{ratingId}")
	public ResponseEntity<List<Rating>> getRatingByRatingId(@PathVariable String ratingId){
		List<Rating> ratings = this.ratingService.getRatingByUserId(ratingId);
		return ResponseEntity.status(HttpStatus.OK).body(ratings);
	}
	
	
	@PutMapping("/")
	public ResponseEntity<Rating> updateRating(@RequestBody Rating rating){
		Rating updatedRating = this.ratingService.updateRating(rating);
		return new ResponseEntity<Rating>(updatedRating,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{ratingId}")
	public ResponseEntity<String> deleteRating(@PathVariable String ratingId){
		String result = this.ratingService.deleteRating(ratingId);
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
}
