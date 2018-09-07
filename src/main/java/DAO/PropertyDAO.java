package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyDAO {

	private DBConnectionFactory DBProperty = new DBConnectionProperties();
	
	public String updateProperty(Map<String, Object> request) {
		Connection conn = DBProperty.getConnection();
		PreparedStatement pstmt = null;
		
		String query = "UPDATE property SET typeOfProperty = ?, sellingPrice = ?, propertyClassification = ?, totalArea = ?, bedroomCount = ?, bathroomCount = ?, amenities = ?, noOfGarage = ?, garageSize = ?, yearBuilt = ?, basement = ?, basementDescription = ?, roofingDescription = ?, additionalRemarks = ?, availabilityStatus = ?, nameOfDeveloper = ?, nameOfProject = ?, userID = ?, datetime = ?, address = ?, city = ?, country = ?, zipCode = ? WHERE propertyID = ?";
		String result = "";
		try {
			conn = DBProperty.getConnection();

			if (conn != null) {
				int i = 1;
				pstmt = conn.prepareStatement(query);
				
				pstmt.setString(i++, request.get("typeOfProperty").toString());
				pstmt.setDouble(i++, Double.parseDouble(request.get("sellingPrice").toString()));
				pstmt.setString(i++, request.get("propertyClassification").toString());
				pstmt.setDouble(i++, Double.parseDouble(request.get("totalArea").toString()));
				pstmt.setInt(i++, Integer.parseInt(request.get("bedroomCount").toString()));
				pstmt.setInt(i++, Integer.parseInt(request.get("bathroomCount").toString()));
				pstmt.setString(i++, request.get("amenities").toString());
				pstmt.setInt(i++, Integer.parseInt(request.get("noOfGarage").toString()));
				pstmt.setDouble(i++, Double.parseDouble(request.get("garageSize").toString()));
				pstmt.setString(i++, request.get("yearBuilt").toString());
				pstmt.setInt(i++, Integer.parseInt(request.get("basement").toString()));
				pstmt.setString(i++, request.get("basementDescription").toString());
				pstmt.setString(i++, request.get("roofingDescription").toString());
				pstmt.setString(i++, request.get("additionalRemarks").toString());
				pstmt.setString(i++, request.get("availabilityStatus").toString());
				pstmt.setString(i++, request.get("nameOfDeveloper").toString());
				pstmt.setString(i++, request.get("nameOfProject").toString());
				pstmt.setInt(i++, Integer.parseInt(request.get("userID").toString()));
				pstmt.setString(i++, request.get("datetime").toString());
				pstmt.setString(i++, request.get("address").toString());
				pstmt.setString(i++, request.get("city").toString());
				pstmt.setString(i++, request.get("country").toString());
				pstmt.setString(i++, request.get("zipCode").toString());
				pstmt.setInt(i++, Integer.parseInt(request.get("propertyID").toString()));
				int rs = pstmt.executeUpdate();
				
				if(rs == 1) {
					result = "Update Success";
				}else {
					result = "Update Fail";
				}
				
			}
		} catch (SQLException ex) {
			Logger.getLogger(PropertyDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBProperty.closeConnection(conn, pstmt);
		}
		return result;
	}
		
}
