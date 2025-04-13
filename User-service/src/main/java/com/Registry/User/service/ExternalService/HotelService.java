package com.Registry.User.service.ExternalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Registry.User.service.entities.Hotel;

//@FeignClient(name = "HOTEL-SERVICE")
@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
	
//	@GetMapping("hotels/{hotelId}")
//	Hotel getHotel( @PathVariable("hotelId") String hotelId);

	@GetMapping(name = "/hotels/{hotelid}")
	public Hotel gethotel(@PathVariable(name = "hotelid",required = true) String hotelid);

	@GetMapping("/hotels/{hotelid}")
	public Hotel savehotel(@PathVariable(name = "hotelid",required = true)String hotelid);

}
