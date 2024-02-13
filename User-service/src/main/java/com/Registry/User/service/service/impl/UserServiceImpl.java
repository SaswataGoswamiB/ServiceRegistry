package com.Registry.User.service.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Registry.User.service.Exception.ResourceNotFoundException;
import com.Registry.User.service.ExternalService.HotelService;
import com.Registry.User.service.ExternalService.RatingService;
import com.Registry.User.service.Repo.UserReposiotory;
import com.Registry.User.service.entities.Hotel;
import com.Registry.User.service.entities.Rating;
import com.Registry.User.service.entities.User;
import com.Registry.User.service.service.UserService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserReposiotory userepoReposiotory;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RatingService ratingService;
	
	
	@Autowired
	private HotelService hotelService;

	
	@Override
	public User saveuser(User user) {
		// TODO Auto-generated method stub
	return 	userepoReposiotory.save(user);
	}

	@Override
	public List<User> getallUserList() {
		// TODO Auto-generated method stub
		return userepoReposiotory.findAll();
	}

	@Override
	public User getUser(Integer id) {
		// TODO Auto-generated method stub
		User user= userepoReposiotory.findById(id).orElseThrow(()->new ResourceNotFoundException("Not Found User !!!!"));
		//fetch Ratings of the above user using RATING SERVICE.
		//http://localhost:8082/ratings/users/211
		//You can use Rest Template or you can Use Feign Client for calling this API.
		//restTemplate.getForObject is used when there are Chances for Multiple values.
		
		
	
		List<Rating>objList=ratingService.getRatings(id.toString());
		
		//log.info("The Array Value is : "+objArray);
		//List<Rating>objArrayList=Arrays.stream(objArray).toList();
		
		log.info("The obj value is : "+objList);
		
		
		
		//restTemplate.getForEntity is used when there are Chances for Single values.
		objList.stream().forEach((rating)->
		{
			log.info("The Hotel id is :"+rating.getHotelId());
			//Hotel hotel=restTemplate.getForEntity("http://localhost:8081/hotels/"+rating.getHotelId(), Hotel.class).getBody();
			
			Hotel hotel=hotelService.getHotel(rating.getHotelId());
			log.info("Hotel value is :"+hotel.getNameString());
			rating.setHotel(hotel);
		});
		
	    user.setRatings(objList);
		
		return user;
	}

}
