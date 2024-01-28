package com.Rating.RatingService.entities;


import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
@Entity(name = "Rating_User")
public class Rating {
	
   @jakarta.persistence.Id
    private String ratingId;
    
    private String userId;
    private String hotelId;
    private  int rating;
    private  String feedback;
}