package com.Rating.RatingService.repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Rating.RatingService.entities.Rating;

public interface RatingRepo extends JpaRepository<Rating,String> {
	
	//customFinderMethod
	
	List<Rating>findByUserId(String UserId);
	
	List<Rating> findByHotelId(String hotelId);


}
