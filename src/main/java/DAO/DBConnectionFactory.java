package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface DBConnectionFactory {
    
    public abstract Connection getConnection();
    
    public abstract void closeConnection(Connection conn, PreparedStatement ps);
    
}
