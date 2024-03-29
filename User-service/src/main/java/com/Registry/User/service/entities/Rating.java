package com.Registry.User.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Rating {

	private String ratingId;

	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;

	private Hotel hotel;

}
