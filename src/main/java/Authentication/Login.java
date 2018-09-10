package Authentication;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DAO.UserDAO;

@RestController
public class Login {

	@RequestMapping("/login")
	public String login(@RequestBody Map<String, Object> login) {
		String word ="";
		UserDAO dao = new UserDAO();
		word = dao.loginUser(login);
		
		return word; 
	}
	
}
