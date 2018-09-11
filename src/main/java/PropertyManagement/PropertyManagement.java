package PropertyManagement;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Entity.Property;

@CrossOrigin
@RestController
public class PropertyManagement {
	
	private DAO.PropertyDAO PropertyDAO = new DAO.PropertyDAO();
	
	@PostMapping("/updateProperty")
	public String updateProperty(@RequestBody Map<String, Object> request) {
			
		return PropertyDAO.updateProperty(request);
	}
	
	@PostMapping(value = "/postProperty")
	public String insertProperty(@RequestBody Map<String, Object> request) {
		String word = PropertyDAO.insertProperty(request);

		return word;
		
	}
	
	@RequestMapping("/viewProperty")
	public Property viewProperty(@RequestParam(value = "propertyID") int propertyID) {
		
		return PropertyDAO.viewProperty(propertyID);
	}
}
