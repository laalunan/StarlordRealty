package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

public class DBConnectionAccounts implements DBConnectionFactory {

	@Autowired
	private DatabaseProperties db;
	
	@Override
	public Connection getConnection() {
		
		try {

			if ("true".equalsIgnoreCase(db.getUseDatabase())) {

				Class.forName(db.getDriverName());
				Connection conn = DriverManager.getConnection(db.getAccountsUrl(),
						db.getDatabaseUsername(), db.getDatabasePassword());
				return conn;
			}

		} catch (ClassNotFoundException | SQLException se) {
			Logger.getLogger(DBConnectionAccounts.class.getName()).log(Level.SEVERE, null, se);
		}
		return null;
	}
}