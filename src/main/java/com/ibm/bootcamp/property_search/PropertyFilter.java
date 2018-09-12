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
	public List<Property> filter(@RequestParam(value= "typeOfProperty") String frequest, @RequestParam(value="sellingPrice") int frequest1, @RequestParam(value="bedroomCount") int frequest2 ,@RequestParam(value="bathroomCount") int frequest3, @RequestParam(value="noOfGarage") double frequest4, @RequestParam(value="garageSize") String frequest5,@RequestParam(value="yearBuilt") int frequest6, @RequestParam(value="basement") int frequest7, @RequestParam(value="totalArea") double frequest8){
	
		return PropertyDAO.filterProperty(frequest, frequest1, frequest2, frequest3, frequest4, frequest5, frequest6, frequest7, frequest8);
		
	}
	

	}
	