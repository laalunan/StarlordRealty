package Authentication;

import org.springframework.beans.factory.annotation.Required;

public class User {
	protected String username;
	protected String email;
	protected String password;
	protected String firstName;
	protected String lastName;
	protected String userType;
	protected int accountStatus;
	protected int authenticationStatus;
	
	public User() {
	}
//	public User(String username, String email, String password, String firstName, String lastName, String userType,
//			int accountStatus, int authenticationStatus) {
//		super();
//		this.username = username;
//		this.email = email;
//		this.password = password;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.userType = userType;
//		this.accountStatus = accountStatus;
//		this.authenticationStatus = authenticationStatus;
//	}
	@Required 
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Required 
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Required 
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Required 
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Required 
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Required 
	public String getUserType() {
		return userType;
	}
	
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Required 
	public int getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}
	@Required 
	public int getAuthenticationStatus() {
		return authenticationStatus;
	}
	public void setAuthenticationStatus(int authenticationStatus) {
		this.authenticationStatus = authenticationStatus;
	}
	
}
