package com.ibm.bootcamp.property_search;

import java.util.List;
import java.util.Map;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ibm.bootcamp.entity.*;
 
@CrossOrigin
@RestController
public class PropertyFilter {

	private com.ibm.bootcamp.dao.PropertyDAO PropertyDAO = new com.ibm.bootcamp.dao.PropertyDAO();

	
	@RequestMapping("/filter")
	public List<Property> filter
	       (@RequestParam(value="minPrice") int min, 
			@RequestParam(value="maxPrice") int max,
			@RequestParam(value="bedroomCount") String frequest2 ,
			@RequestParam(value="bathroomCount") String frequest3, 
			@RequestParam(value="noOfGarage") String frequest4, 
			@RequestParam(value="garageSize") String frequest5,
			@RequestParam(value="yearBuilt") String frequest6, 
			@RequestParam(value="basement") int frequest7, 
			@RequestParam(value="totalArea") String frequest8, 
			@RequestParam(value="amenities") String frequest9, 
			@RequestParam(value="size") int size){
			
		return PropertyDAO.filterProperty(min, max, frequest2, frequest3, frequest4, frequest5, frequest6, frequest7, frequest8, frequest9, size);
		
	}
	

	}
	