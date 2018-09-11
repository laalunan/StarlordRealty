package com.ibm.bootcamp.user_profile;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bootcamp.authentication.User;
import com.ibm.bootcamp.dao.UserDAO;
import com.ibm.bootcamp.entity.Account;

@CrossOrigin
@RestController
public class ViewProfile {
	private com.ibm.bootcamp.dao.UserDAO UserDAO = new com.ibm.bootcamp.dao.UserDAO();

	@RequestMapping("/viewprofile")
	public List<User> view(@RequestBody Map<String, Object> request) {
		
		
		return UserDAO.viewProfile(request);
	}
}
