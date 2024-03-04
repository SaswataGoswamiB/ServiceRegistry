package com.Registry.User.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Registry.User.service.entities.User;
import com.Registry.User.service.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);


	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User user1 = userService.saveuser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}

	@GetMapping("/{userId}")
	//@CircuitBreaker(name = "RatingHotelBreaker",fallbackMethod = "ratingHotelFallBack")
	@Retry(name = "ratinghotelRetry",fallbackMethod ="ratingHotelRetry")
	@CircuitBreaker(name = "RatingHotelBreaker",fallbackMethod = "ratingHotelFallBack")
	public ResponseEntity<User> getSingleUser(@PathVariable("userId") Integer userId) {
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);

	}
	
	//creating Fall BAck Method for Circuit Breaker
	
	public ResponseEntity<User> ratingHotelFallBack(Integer userId,Exception ex)
	{
		logger.info("FallBack is executed because Service is down",ex.getMessage());
		
		User user=User.builder().
				email("saswata@email.com").
				name("This User is dummy from Circuit Breaker").
				userId(123).
				build();
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	// Implemeting Retry from Resileine4j.
	
	int countRetry=1;
	public ResponseEntity<User> ratingHotelRetry(Integer userId,Exception ex)
	{
		logger.info("Retry  is executed because Service is Slow or Network Issue",countRetry);
		countRetry++;
		User user=User.builder().
				email("saswata@Retry.com").
				name("This User is dummy from Retry").
				userId(123).
				about("This is the retry from the Releience4j").
				build();
		return new ResponseEntity<>(user,HttpStatus.OK);
	}

	// all user get
	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> allUser = userService.getallUserList();
		return ResponseEntity.ok(allUser);
	}

}
