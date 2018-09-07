package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyDAO {

	private DBConnectionFactory DBProperty = new DBConnectionProperties();
	
	public void updateProperty(Map<String, Object> request) {
		Connection conn = DBProperty.getConnection();
		PreparedStatement pstmt = null;
		
		String query = "UPDATE property SET";
		try {
			conn = DBProperty.getConnection();

			if (conn != null) {
				int i = 1;
				pstmt = conn.prepareStatement(query);

			}
		} catch (SQLException ex) {
			Logger.getLogger(PropertyDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBProperty.closeConnection(conn, pstmt);
		}
	}
		
}
