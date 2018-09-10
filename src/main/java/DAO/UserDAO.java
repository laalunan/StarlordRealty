package DAO;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.exceptions.RSAException;

import Authentication.User;


public class UserDAO {
	
	private DBConnectionFactory DBAccount = new DBConnectionAccounts();
	
	public String registerUser(Map<String, Object> register) {
		Connection conn = DBAccount.getConnection();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		String response ="";
		ResultSet rs = null;
		
		
		try {

		    String query = "SELECT username FROM accounts where username=?";
		    pstmt1 = conn.prepareStatement(query);
		    pstmt1.setString(1, register.get("username").toString());
			rs = pstmt1.executeQuery();
		    
		if (rs.next() && conn!=null) { 
			response = "User already exists!";
			
		}else {
			String query2 ="INSERT INTO accounts (username, email, password, firstName, lastName, userType, accountStatus, authenticationStatus) VALUES (?,?,?,?,?,?,?,?)";
			int i = 1;
			pstmt = conn.prepareStatement(query2);
			
			pstmt.setString(i++, register.get("username").toString());
			pstmt.setString(i++, register.get("email").toString());
			pstmt.setString(i++, register.get("password").toString());
			pstmt.setString(i++, register.get("firstName").toString());
			pstmt.setString(i++, register.get("lastName").toString());
			pstmt.setString(i++, register.get("userType").toString());
			pstmt.setInt(i++, Integer.parseInt(register.get("accountStatus").toString()));
			pstmt.setInt(i++, Integer.parseInt(register.get("authenticationStatus").toString()));
			
//			MessageDigest digest = MessageDigest.getInstance("SHA-256");
//			byte[] hash = digest.digest(register.get("password").getBytes(StandardCharsets.UTF_8));
			
			pstmt.executeUpdate();
			
			
			response ="Successfully registered!";
			
		}
		}catch (SQLException e) {
			Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		} finally {
			 DBAccount.closeConnection(conn, pstmt);
		} return response;
	}
	
	public String loginUser(Map<String, Object> login) {
		Connection conn = DBAccount.getConnection();
		
		PreparedStatement pstmt = null;
		String response="";
		try {
		conn = DBAccount.getConnection();
		
		if (conn!=null) { 
			String query ="SELECT * FROM accounts WHERE username = ? AND password = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, login.get("username").toString());
			pstmt.setString(2, login.get("password").toString());
			ResultSet rs = pstmt.executeQuery();
		
			if(rs.next()) {
				response = "Login Success";
			} else {
				response="Login Fail";
			}
		} }catch (SQLException ex) {
			Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBAccount.closeConnection(conn, pstmt);
		}
		return response;
	}

	public List<User> viewProfile(Map<String, Object> request){
		List<User> userdetails = new ArrayList<User>();
		Connection conn = DBAccount.getConnection();
		
		String query = "select * from accounts where username = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, request.get("username").toString());
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setUserType(rs.getString("userType"));
				user.setAccountStatus(rs.getInt("accountStatus"));
				user.setAuthenticationStatus(rs.getInt("authenticationStatus"));
				userdetails.add(user);
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userdetails;
	}
}
	
	
	

	

