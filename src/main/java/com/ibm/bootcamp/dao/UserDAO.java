package com.ibm.bootcamp.dao;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.security.NoSuchAlgorithmException;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.DatatypeConverter;

import com.ibm.bootcamp.authentication.User;
import com.ibm.bootcamp.entity.Account;
import com.ibm.bootcamp.entity.Property;

public class UserDAO {
	
	private DBConnectionFactory DBAccount = new DBConnectionAccounts();
	
	//Register a new account
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
		
			String rawPass = register.get("password").toString();
			String hashPass = getSHA256Hash(rawPass);
			
			String query2 ="INSERT INTO accounts (username, email, password, firstName, lastName, userType, accountStatus) VALUES (?,?,?,?,?,?,?)";
			int j = 1;
			pstmt = conn.prepareStatement(query2);
			
			pstmt.setString(j++, register.get("username").toString());
			pstmt.setString(j++, register.get("email").toString());
			pstmt.setString(j++, hashPass);
			pstmt.setString(j++, register.get("firstName").toString());
			pstmt.setString(j++, register.get("lastName").toString());
			pstmt.setString(j++, register.get("userType").toString());
			pstmt.setInt(j++, Integer.parseInt(register.get("accountStatus").toString()));

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
	
	private String getSHA256Hash(String data) {
	String result = null;
       try {
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] hash = digest.digest(data.getBytes("UTF-8"));
	            return bytesToHex(hash); // make it printable
	        }
       catch(Exception ex) {
	            ex.printStackTrace();
	        }
	        return result;
	}
	
	private String bytesToHex(byte[] hash) {
		// TODO Auto-generated method stub
		return DatatypeConverter.printHexBinary(hash);
	}
	
	//Login
	public String loginUser(Map<String, Object> login) {
		Connection conn = DBAccount.getConnection();
		PreparedStatement pstmt = null;
		String response = "";
		try {
			conn = DBAccount.getConnection();

			if (conn != null) {
				String rawPass = login.get("password").toString();
				String hashPass = getSHA256Hash(rawPass);
				String query = "SELECT username, password, userType, accountStatus FROM accounts WHERE username = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, login.get("username").toString());
				
				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					if(hashPass.equals(rs.getString("password")) && rs.getInt("accountStatus") == 1) {
						
						Account a = new Account();
						a.setUserType(rs.getString("userType"));
						
						
						response = rs.getString("UserType");
						
					}
					
					else if(rs.getInt("accountStatus") == 0)
					{
						response = "Account Suspended";
					}
					
					
					
					else {
						response = "Incorrect Password";
					}
					
				} else {
					response = "Account is Non-Existent";
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBAccount.closeConnection(conn, pstmt);
		}
		return response;
	}
	
	//View Profile
	public List<User> viewProfile(Map<String, Object> request) {
		List<User> userdetails = new ArrayList<User>();
		Connection conn = DBAccount.getConnection();

		String query = "select * from accounts where username = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, request.get("username").toString());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
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

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userdetails;
	}
	
	//Update User Profile

	public String updateProfile(Map<String, Object> request) {
		Connection conn = DBAccount.getConnection();
		PreparedStatement pstmt = null;

		String query = "UPDATE accounts SET email = ?, firstName = ?, lastName = ? WHERE username = ?";
		String result = "";

		try {
			conn = DBAccount.getConnection();

			if (conn != null) {
				int i = 1;
				pstmt = conn.prepareStatement(query);

				
				pstmt.setString(i++, request.get("email").toString());
				pstmt.setString(i++, request.get("firstName").toString());
				pstmt.setString(i++, request.get("lastName").toString());
				
				pstmt.setString(i++, request.get("username").toString());

				int rs = pstmt.executeUpdate();
				if (rs == 1) {
					result = "Update Success";
				} else {
					result = "Update Fail";
				}
			}

		} catch (SQLException ex) {
			Logger.getLogger(PropertyDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBAccount.closeConnection(conn, pstmt);
		}
		return result;
	}
	
	//Update Account Status 
	public String updateStatus(Map<String, Object> request) {
		Connection conn = DBAccount.getConnection();
		PreparedStatement pstmt = null;

		String query = "UPDATE accounts SET accountStatus = ? WHERE username = ?";
		String result = "";
		
		try {
			conn = DBAccount.getConnection();

			if (conn != null) {
				int i = 1;
				pstmt = conn.prepareStatement(query);

				pstmt.setInt(i++, Integer.parseInt(request.get("accountStatus").toString()));
				
				pstmt.setString(i++, request.get("username").toString());

				int rs = pstmt.executeUpdate();
				if (rs == 1) {
					result = "Update Account Status";
				} else {
					result = "Update Fail";
				}
			}

		} catch (SQLException ex) {
			Logger.getLogger(PropertyDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBAccount.closeConnection(conn, pstmt);
		}
		return result;
	}
	
	//Password Reset
	public String resetPassword(Map<String, Object> request) {
		Connection conn = DBAccount.getConnection();
		PreparedStatement pstmt = null;

		String query = "UPDATE accounts SET password = ? WHERE username = ?";
		String result = "";
		
		try {
			conn = DBAccount.getConnection();

			if (conn != null) {
				int rs;
				String rawPass = request.get("password").toString();
				String rawPass2 = request.get("reenterpassword").toString();
				
				if(rawPass.equals(rawPass2))
				{
					String hashPass = getSHA256Hash(rawPass);
					int i = 1;
					pstmt = conn.prepareStatement(query);

					pstmt.setString(i++, hashPass);
					
					pstmt.setString(i++, request.get("username").toString());

					rs = pstmt.executeUpdate();
					
					if (rs == 1) {
						result = "Password Updated!";
					}
				}
				else {
					result = "Update Fail";
				}
			}

		} catch (SQLException ex) {
			Logger.getLogger(PropertyDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBAccount.closeConnection(conn, pstmt);
		}
		return result;
	}
		

}
