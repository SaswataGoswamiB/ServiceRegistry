package com.Service.HotelService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
@Entity(name = "Hotels")
public class Hotel {
	
	@Id
	private String idString;
	
	private String nameString;
	
	private String locationString;
	
	private String aboutString;

}
