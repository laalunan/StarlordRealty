package DAO;

import java.sql.Connection;

public interface DBConnectionFactory {
    
    public abstract Connection getConnection();
    
}
