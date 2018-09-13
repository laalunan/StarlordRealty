package com.ibm.bootcamp.authentication;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bootcamp.dao.UserDAO;

@CrossOrigin
@RestController
public class Registration {
	
	
	@RequestMapping("/register")
	public String register(@RequestBody Map<String, Object> register) {
		String word ="";
		UserDAO dao = new UserDAO();
		word = dao.registerUser(register);
		
		return word; 
	}
}
