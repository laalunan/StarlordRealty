package com.ibm.bootcamp.property_search;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.bootcamp.entity.Property;

@CrossOrigin
@RestController
public class PropertySearch {

	private com.ibm.bootcamp.dao.PropertyDAO PropertyDAO = new com.ibm.bootcamp.dao.PropertyDAO();

	@RequestMapping("/sortProperty")
	public Map<String, List<Property>> sortProperty() {
		
		return PropertyDAO.sortProperty();
	}
	
	@RequestMapping(value="/search")
	public List<Property> search(@RequestBody Map<String, Object> request){
				
		
		return PropertyDAO.searchProperty(request);
		
	}
	

	
}
