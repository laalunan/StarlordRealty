package com.ibm.bootcamp.authentication;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bootcamp.dao.UserDAO;

@CrossOrigin
@RestController
public class Login {

	@RequestMapping("/login")
	public String login(@RequestBody Map<String, Object> login, HttpSession session) {
		String word ="";
		UserDAO dao = new UserDAO();
		word = dao.loginUser(login);
		
		if(word.equals("Broker") || word.equals("Admin") || word.equals("SalesAgent")) {
			session.setAttribute("userID", dao.getUserID(login.get("username").toString()));
			session.setAttribute("username", login.get("username").toString());
		}
		
		return word; 
	}
}
