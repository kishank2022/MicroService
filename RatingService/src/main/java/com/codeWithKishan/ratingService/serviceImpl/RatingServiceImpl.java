package com.codeWithKishan.ratingService.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeWithKishan.ratingService.entities.Rating;
import com.codeWithKishan.ratingService.repositories.RatingRepository;
import com.codeWithKishan.ratingService.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating createRating(Rating rating) {
		Rating savedRating = this.ratingRepository.save(rating);
		return savedRating;
	}

	@Override
	public List<Rating> getAllRatings() {
		List<Rating> ratings = this.ratingRepository.findAll();
		return ratings;
	}

	@Override
	public Rating getRating(String ratingId) {
		Optional<Rating> rating = this.ratingRepository.findById(ratingId);
		Rating rating1 = new Rating();
		if(rating.isPresent()) {
			rating1 = rating.get();
		}
		return rating1;
	}

	@Override
	public String deleteRating(String ratingId) {
		Optional<Rating> rating = this.ratingRepository.findById(ratingId);
		Rating rating1 = new Rating();
		if(rating.isPresent()) {
			rating1 = rating.get();
			this.ratingRepository.delete(rating1);
			return "Rating deleted successfully !!! ";
		}else {
		return "Rating with "+ratingId+" is not found !! ";
		}
	}

	@Override
	public Rating updateRating(Rating rating) {
		Optional<Rating> optional = this.ratingRepository.findById(rating.getRatingId());
		Rating rating1 = new Rating();
		if(optional.isPresent()) {
			rating1 = this.ratingRepository.save(optional.get());
			return rating1;
		}
		return rating1;
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		List<Rating> ratings = this.ratingRepository.findByUserId(userId);
		return ratings;
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		List<Rating> ratings = this.ratingRepository.findByHotelId(hotelId);
		return ratings;
	}

}
