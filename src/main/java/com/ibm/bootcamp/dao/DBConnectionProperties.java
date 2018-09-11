package com.ibm.bootcamp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnectionProperties implements DBConnectionFactory {

	@Override
	public Connection getConnection() {

		try {

			if ("true".equalsIgnoreCase("true")) {

				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/properties", "gradhire", "bootcamp");
				return conn;
			}

		} catch (ClassNotFoundException | SQLException se) {
			Logger.getLogger(DBConnectionProperties.class.getName()).log(Level.SEVERE, null, se);
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
		if (conn != null) {
			try {
				s.close();
				conn.close();
			} catch (Exception e) {
				System.out.println("DATABASE ERROR: CLOSING");
			}
		}
	}
}