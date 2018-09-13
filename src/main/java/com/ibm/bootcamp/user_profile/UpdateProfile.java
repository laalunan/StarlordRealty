package com.ibm.bootcamp.user_profile;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bootcamp.entity.Account;

@CrossOrigin
@RestController
public class UpdateProfile {
	
	private com.ibm.bootcamp.dao.UserDAO UserDAO = new com.ibm.bootcamp.dao.UserDAO();
	
	@PostMapping("/updateprofile")
	public String updateProfile(@RequestBody Map<String, Object> request) {
	  		
		return UserDAO.updateProfile(request);
}
}
