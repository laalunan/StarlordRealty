package com.ibm.bootcamp.property_search;

import java.util.List;
import java.util.Map;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bootcamp.entity.Property;

@CrossOrigin
@RestController
public class PropertySearch {

	private com.ibm.bootcamp.dao.PropertyDAO PropertyDAO = new com.ibm.bootcamp.dao.PropertyDAO();

	@RequestMapping("/sortProperty")
	public Map<String, List<Property>> sortProperty() {
		
		return PropertyDAO.sortProperty();
	}
	
	@RequestMapping("/search")
	public List<Property> search(@RequestParam(value= "city") String request, @RequestParam(value="typeOfProperty") String request1, @RequestParam(value="propertyClassification") String request2){
				
		
		return PropertyDAO.searchProperty(request, request1, request2);
		
	}
	

	
}
