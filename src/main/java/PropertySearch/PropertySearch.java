package PropertySearch;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Entity.Property;

@CrossOrigin
@RestController
public class PropertySearch {

	private DAO.PropertyDAO PropertyDAO = new DAO.PropertyDAO();

	@RequestMapping("/sortProperty")
	public Map<String, List<Property>> sortProperty() {
		
		return PropertyDAO.sortProperty();
	}

}
