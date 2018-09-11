package com.ibm.bootcamp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public interface DBConnectionFactory {
    
    public abstract Connection getConnection();
    
    public abstract void closeConnection(Connection conn, PreparedStatement ps);

	public abstract void closeConnection(Connection conn, Statement s);
    
   
    
}
