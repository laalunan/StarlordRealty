package UserProfile;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Entity.Account;
import DAO.UserDAO;
import Authentication.User;

@CrossOrigin
@RestController
public class ViewProfile {
	private DAO.UserDAO UserDAO = new DAO.UserDAO();

	@RequestMapping("/viewprofile")
	public List<User> view(@RequestBody Map<String, Object> request) {
		
		
		return UserDAO.viewProfile(request);
	}
}
