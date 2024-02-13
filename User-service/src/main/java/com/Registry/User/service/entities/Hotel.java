package com.Registry.User.service.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Hotel {

	
	private String idString;
	
	private String nameString;
	
	private String locationString;
	
	private String aboutString;

}
