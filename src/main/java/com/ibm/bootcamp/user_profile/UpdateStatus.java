package com.ibm.bootcamp.user_profile;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UpdateStatus {
	
	private com.ibm.bootcamp.dao.UserDAO UserDAO = new com.ibm.bootcamp.dao.UserDAO();

	@PostMapping("/updatestatus")
	public String updateStatus(@RequestBody Map<String, Object> request) {
			
		return UserDAO.updateStatus(request);
}
}