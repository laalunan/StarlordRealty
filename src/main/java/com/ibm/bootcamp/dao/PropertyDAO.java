package com.ibm.bootcamp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ibm.bootcamp.entity.Property;
import com.mysql.cj.protocol.Resultset;

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

	public Map<String, List<Property>> sortProperty() {
		List<Property> propertyList = new ArrayList<Property>();

		Map<String, List<Property>> map = new HashMap<String, List<Property>>();

		Connection myConn = DBProperty.getConnection();
		Statement s = null;
		try {
			s = myConn.createStatement();
			ResultSet myRs = s.executeQuery(
					"SELECT propertyID, typeOfProperty, sellingPrice, bedroomCount, city " + "FROM properties.property "
							+ "WHERE availabilityStatus = \"AVAILABLE\" " + "ORDER BY dateTime DESC, clickCount DESC;");

			while (myRs.next()) {
				Property p = new Property();

				p.setPropertyID(myRs.getInt("propertyID"));
				p.setTypeOfProperty(myRs.getString("typeOfProperty"));
				p.setSellingPrice(myRs.getInt("sellingPrice"));
				p.setBedroomCount(myRs.getInt("bedroomCount"));
				p.setCity(myRs.getString("city"));

				propertyList.add(p);
			}

			map.put("properties", propertyList);

		} catch (Exception e) {
			Logger.getLogger(PropertyDAO.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			DBProperty.closeConnection(myConn, s);
		}

		return map;

	}

	public List<Property> searchProperty(String request, String request1, String request2){
		
		List<Property> propertylist = new ArrayList<Property>();
		
		Connection conn = DBProperty.getConnection();
		PreparedStatement pstmt = null;
		Statement stmt = null;
		
		
		
		String query = "SELECT * FROM properties.property where city = ? AND typeOfProperty = ? AND propertyClassification=? AND availabilityStatus = 'AVAILABLE' ORDER BY dateTime DESC, clickCount DESC;";
		String query1 = "SELECT * FROM properties.property WHERE availabilityStatus = 'AVAILABLE' ORDER BY dateTime DESC, clickCount DESC;";
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, request);
			pstmt.setString(2, request1);
			pstmt.setString(3, request2);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(!request.isEmpty())
			{
				System.out.println("hello");
				while (rs.next()) {
					
					Property p = new Property();
					
					p.setPropertyID(rs.getInt("propertyID"));
					p.setCity(rs.getString("city"));
					p.setTypeOfProperty(rs.getString("typeOfProperty"));
					p.setPropertyClassification(rs.getString("propertyClassification"));
					p.setSellingPrice(rs.getDouble("sellingPrice"));
					p.setBedroomCount(rs.getInt("bedroomCount"));
					p.setBathroomCount(rs.getInt("bathroomCount"));
					p.setAmenities(rs.getString("amenities"));
					p.setNoOfGarage(rs.getInt("noOfGarage"));
					p.setGarageSize(rs.getDouble("garageSize"));
					p.setYearBuilt(rs.getString("yearBuilt"));
					p.setBasement(rs.getInt("basement"));
					p.setBasementDescription(rs.getString("basementDescription"));
					p.setRoofingDescription(rs.getString("roofingDescription"));
					p.setAdditionalRemarks(rs.getString("additionalRemarks"));
					p.setAvailabilityStatus(rs.getString("availabilityStatus"));
					p.setNameOfDeveloper(rs.getString("nameOfDeveloper"));
					p.setNameOfProject(rs.getString("nameOfProject"));
					p.setDateTime(rs.getString("dateTime"));
					p.setAddress(rs.getString("address"));
					p.setCountry(rs.getString("country"));
					p.setZipCode(rs.getString("zipCode"));
					p.setClickCount(rs.getInt("clickCount"));
					p.setTotalArea(rs.getDouble("totalArea"));
					
					propertylist.add(p);
				}
			}
			else if(request.isEmpty()) {
				//print all
				System.out.println("must print pls!");
				Statement s = conn.createStatement();
				ResultSet myRs = s.executeQuery(query1);
			
				while(myRs.next()) {
					
					Property p = new Property();
					System.out.println("hi");
					p.setPropertyID(myRs.getInt("propertyID"));
					p.setCity(myRs.getString("city"));
					p.setTypeOfProperty(myRs.getString("typeOfProperty"));
					p.setPropertyClassification(myRs.getString("propertyClassification"));
					p.setSellingPrice(myRs.getDouble("sellingPrice"));
					p.setBedroomCount(myRs.getInt("bedroomCount"));
					p.setBathroomCount(myRs.getInt("bathroomCount"));
					p.setAmenities(myRs.getString("amenities"));
					p.setNoOfGarage(myRs.getInt("noOfGarage"));
					p.setGarageSize(myRs.getDouble("garageSize"));
					p.setYearBuilt(myRs.getString("yearBuilt"));
					p.setBasement(myRs.getInt("basement"));
					p.setBasementDescription(myRs.getString("basementDescription"));
					p.setRoofingDescription(myRs.getString("roofingDescription"));
					p.setAdditionalRemarks(myRs.getString("additionalRemarks"));
					p.setAvailabilityStatus(myRs.getString("availabilityStatus"));
					p.setNameOfDeveloper(myRs.getString("nameOfDeveloper"));
					p.setNameOfProject(myRs.getString("nameOfProject"));
					p.setDateTime(myRs.getString("dateTime"));
					p.setAddress(myRs.getString("address"));
					p.setCountry(myRs.getString("country"));
					p.setZipCode(myRs.getString("zipCode"));
					p.setClickCount(myRs.getInt("clickCount"));
					p.setTotalArea(myRs.getDouble("totalArea"));
					
					propertylist.add(p);
				}
				
			}
			
			
		} catch (Exception e) {
		}finally {
			DBProperty.closeConnection(conn, pstmt);
		}	
		
		return propertylist;
		
	}
	public Property viewProperty(int propertyID) {
		Connection conn = DBProperty.getConnection();
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM property WHERE propertyID = ?";

		Property p = new Property();
		ResultSet rs = null;
		try {

			if (conn != null) {
				int i = 1;

				pstmt = conn.prepareStatement(query);
				pstmt.setInt(i++, propertyID);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					p.setPropertyID(rs.getInt("propertyID"));
					p.setTypeOfProperty(rs.getString("typeOfProperty"));
					p.setSellingPrice(rs.getDouble("sellingPrice"));
					p.setPropertyClassification(rs.getString("propertyClassification"));
					p.setTotalArea(rs.getDouble("totalArea"));
					p.setBedroomCount(rs.getInt("bedroomCount"));
					p.setBathroomCount(rs.getInt("bathroomCount"));
					p.setAmenities(rs.getString("amenities"));
					p.setNoOfGarage(rs.getInt("noOfGarage"));
					p.setGarageSize(rs.getDouble("garageSize"));
					p.setYearBuilt(rs.getString("yearBuilt"));
					p.setBasement(rs.getInt("basement"));
					p.setBasementDescription(rs.getString("basementDescription"));
					p.setRoofingDescription(rs.getString("roofingDescription"));
					p.setAdditionalRemarks(rs.getString("additionalRemarks"));
					p.setAvailabilityStatus(rs.getString("availabilityStatus"));
					p.setNameOfDeveloper(rs.getString("nameOfDeveloper"));
					p.setNameOfProject(rs.getString("nameOfProject"));
					p.setUserID(rs.getInt("userID"));
					p.setDateTime(rs.getString("dateTime"));
					p.setAddress(rs.getString("address"));
					p.setCity(rs.getString("city"));
					p.setCountry(rs.getString("country"));
					p.setZipCode(rs.getString("zipCode"));
					p.setClickCount(rs.getInt("clickCount"));
				}

				query = "UPDATE property SET clickCount = (SELECT clickCount WHERE propertyID = ?)+1 WHERE propertyID = ?";

				int j = 1;

				pstmt = conn.prepareStatement(query);
				pstmt.setInt(j++, propertyID);
				pstmt.setInt(j++, propertyID);
				int s = pstmt.executeUpdate();
			}

		} catch (SQLException ex) {
			Logger.getLogger(PropertyDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBProperty.closeConnection(conn, pstmt);
		}
		return p;
	}
	
	public List<Property> filterProperty(Map<String,Object> request)  {
		List<Property> propertyList = new ArrayList<Property>();
		Connection myConn = DBProperty.getConnection();
		PreparedStatement fpstmt = null;
		
		String filter = "SELECT * FROM properties.property WHERE typeOfProperty = ? AND sellingPrice > ? AND bedroomCount =? AND bathroomCount = ? AND noOfGarage = ? AND garageSize = ? AND yearBuilt = ? AND basement = ? AND totalArea = ? ";
		//String filter = "SELECT * FROM properties.property WHERE amenities LIKE ? ";

		for (int i=0; i < Integer.parseInt(request.get("size").toString()); i++) {
			filter += "AND amenities LIKE ?"; 
		}
		
		try {
			fpstmt = myConn.prepareStatement(filter);
			
			
			fpstmt.setString(1, request.get("typeOfProperty").toString());
			fpstmt.setDouble(2, Double.parseDouble(request.get("sellingPrice").toString()));
			fpstmt.setInt(3, Integer.parseInt(request.get("bedroomCount").toString()));
			fpstmt.setInt(4, Integer.parseInt(request.get("bathroomCount").toString()));
			fpstmt.setInt(5, Integer.parseInt(request.get("noOfGarage").toString()));
			fpstmt.setDouble(6, Double.parseDouble(request.get("garageSize").toString()));
			fpstmt.setString(7,(request.get("yearBuilt").toString()));
			fpstmt.setInt(8, Integer.parseInt(request.get("basement").toString()));
			fpstmt.setDouble(9, Double.parseDouble(request.get("totalArea").toString()));
			for (int i=10; i <= Integer.parseInt(request.get("size").toString())+9; i++) {
				fpstmt.setString(i, "%" + request.get("amenities"+i).toString() + "%");
			}
			ResultSet rs = fpstmt.executeQuery();
			
			
			while (rs.next()) {
				Property p = new Property();
				p.setTypeOfProperty(rs.getString("typeOfProperty"));
				p.setSellingPrice(rs.getDouble("sellingPrice"));
				p.setAmenities(rs.getString("amenities"));
				p.setBedroomCount(rs.getInt("bedroomCount"));
				p.setBathroomCount(rs.getInt("bathroomCount"));
				p.setNoOfGarage(rs.getInt("noOfGarage"));
				p.setGarageSize(rs.getInt("garageSize"));
				p.setYearBuilt(rs.getString("yearBuilt"));
				p.setBasement(rs.getInt("basement"));
				p.setTotalArea(rs.getDouble("totalArea"));

				propertyList.add(p);
			}
	
		} catch (SQLException e) {
			Logger.getLogger(PropertyDAO.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		} finally {
			DBProperty.closeConnection(myConn, fpstmt);
		}

		return propertyList; 
	}
	
	public List<Property> viewMyProperties(int request){
		
		List<Property> propertylist = new ArrayList<Property>();
		
		Connection conn = DBProperty.getConnection();
		PreparedStatement pstmt = null;
		
		
		
		String query = "SELECT * FROM properties.property where userID = ?";
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, request);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				Property p = new Property();
				
				p.setPropertyID(rs.getInt("propertyID"));
				p.setCity(rs.getString("city"));
				p.setTypeOfProperty(rs.getString("typeOfProperty"));
				p.setPropertyClassification(rs.getString("propertyClassification"));
				p.setSellingPrice(rs.getDouble("sellingPrice"));
				p.setBedroomCount(rs.getInt("bedroomCount"));
				p.setBathroomCount(rs.getInt("bathroomCount"));
				p.setAmenities(rs.getString("amenities"));
				p.setNoOfGarage(rs.getInt("noOfGarage"));
				p.setGarageSize(rs.getDouble("garageSize"));
				p.setYearBuilt(rs.getString("yearBuilt"));
				p.setBasement(rs.getInt("basement"));
				p.setBasementDescription(rs.getString("basementDescription"));
				p.setRoofingDescription(rs.getString("roofingDescription"));
				p.setAdditionalRemarks(rs.getString("additionalRemarks"));
				p.setAvailabilityStatus(rs.getString("availabilityStatus"));
				p.setNameOfDeveloper(rs.getString("nameOfDeveloper"));
				p.setNameOfProject(rs.getString("nameOfProject"));
				p.setDateTime(rs.getString("dateTime"));
				p.setAddress(rs.getString("address"));
				p.setCountry(rs.getString("country"));
				p.setZipCode(rs.getString("zipCode"));
				p.setClickCount(rs.getInt("clickCount"));
				p.setTotalArea(rs.getDouble("totalArea"));
				
				propertylist.add(p);
			}
		} catch (Exception e) {
		}finally {
			DBProperty.closeConnection(conn, pstmt);
		}	
		
		return propertylist;
		
	}
	
	
}
