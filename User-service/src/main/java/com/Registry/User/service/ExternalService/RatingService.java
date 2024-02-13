package com.Registry.User.service.ExternalService;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.Registry.User.service.entities.Rating;

@Service
@FeignClient(value = "RATING-SERVICE")
public interface RatingService {
	
	@GetMapping("/ratings/users/{userId}")
	List<Rating> getRatings(@PathVariable("userId")String userId);
	
	//Post
	
	@PostMapping("/ratings")
    public Rating createRating(Rating values);


    //PUT
    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);


    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);


}
