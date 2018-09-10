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

				if (rs == 1) {
					result = "Update Success";
				} else {
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

	public String insertProperty(Map<String, Object> request) {
		Connection conn = DBProperty.getConnection();

		PreparedStatement pstmt = null;
		String query = "";
		String word = "";
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			query = "insert into property(typeOfProperty, sellingPrice, propertyClassification, "
					+ "bedroomCount, bathroomCount, amenities, noOfGarage, garageSize, yearBuilt, "
					+ "basement, basementDescription, roofingDescription, additionalRemarks, "
					+ "availabilityStatus, nameOfDeveloper, nameOfProject, userID, dateTime, address, city, "
					+ "country, zipCode, clickCount) " + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, request.get("typeOfProperty").toString());
			pstmt.setDouble(2, Double.parseDouble(request.get("sellingPrice").toString()));
			pstmt.setString(3, request.get("propertyClassification").toString());
			pstmt.setInt(4, Integer.parseInt(request.get("bedroomCount").toString()));
			pstmt.setInt(5, Integer.parseInt(request.get("bathroomCount").toString()));
			pstmt.setString(6, request.get("amenities").toString());
			pstmt.setInt(7, Integer.parseInt(request.get("noOfGarage").toString()));
			pstmt.setDouble(8, Double.parseDouble(request.get("garageSize").toString()));
			pstmt.setString(9, request.get("yearBuilt").toString());
			pstmt.setInt(10, Integer.parseInt(request.get("basement").toString()));
			pstmt.setString(11, request.get("basementDescription").toString());
			pstmt.setString(12, request.get("roofingDescription").toString());
			pstmt.setString(13, request.get("additionalRemarks").toString());
			pstmt.setString(14, request.get("availabilityStatus").toString());
			pstmt.setString(15, request.get("nameOfDeveloper").toString());
			pstmt.setString(16, request.get("nameOfProject").toString());
			pstmt.setInt(17, Integer.parseInt(request.get("userID").toString()));
			pstmt.setString(18, sdf.format(dt));
			pstmt.setString(19, request.get("address").toString());
			pstmt.setString(20, request.get("city").toString());
			pstmt.setString(21, request.get("country").toString());
			pstmt.setString(22, request.get("zipcode").toString());
			pstmt.setInt(23, 0);
			int result = pstmt.executeUpdate();

			if (result == 1) {
				word = "success!";
			}

		} catch (SQLException ex) {
			word = "may mali ka";
			ex.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return word;
	}
}
