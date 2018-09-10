package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

public class DBConnectionAccounts implements DBConnectionFactory {

	@Autowired
	private DatabaseProperties db;
	
	@Override
	public Connection getConnection() {
		
		try {

			if ("true".equalsIgnoreCase("true")) {

				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts",
						"gradhire", "bootcamp");
				return conn;
			}

		} catch (ClassNotFoundException | SQLException se) {
			Logger.getLogger(DBConnectionAccounts.class.getName()).log(Level.SEVERE, null, se);
		}
		return null;
	}
	
	@Override
	public void closeConnection(Connection conn, PreparedStatement ps) {
		if (conn != null) {
			try {
				ps.close();
				conn.close();
			} catch (Exception e) {
				System.out.println("DATABASE ERROR: CLOSING");
			}
		}
	}

	@Override
	public void closeConnection(Connection conn, Statement s) {
		// TODO Auto-generated method stub
		
	}
}