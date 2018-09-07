package PropertyManagement;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class PropertyManagement {
	
	@RequestMapping("/updateProperty")
	public void updateProperty(Map<String, Object> request) {
		
	}
	
}
