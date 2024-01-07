package com.Registry.User.service.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Registry.User.service.PayLoad.ApiResponse;

@RestControllerAdvice
public class GlobalExcpetionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse>handleResourcenotFound(ResourceNotFoundException ex)
	{
		String messString=ex.getMessage();
		ApiResponse buiApiResponse=ApiResponse.builder().message(messString).successs(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ApiResponse>(buiApiResponse, HttpStatus.NOT_FOUND);
	}

}
