package com.ibm.bootcamp.property_search;

import java.util.List;
import java.util.Map;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ibm.bootcamp.entity.*;
 
@CrossOrigin
@RestController
public class PropertyFilter {

	private com.ibm.bootcamp.dao.PropertyDAO PropertyDAO = new com.ibm.bootcamp.dao.PropertyDAO();

	@RequestMapping("/filterProperty")
	public List<Property> filterProperty(@RequestBody Map<String, Object> request) {
		
		return PropertyDAO.filterProperty(request);
	}

	}
	