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

		String query = "UPDATE property SET typeOfProperty = ?, sellingPrice = ?, propertyClassification = ?, totalArea = ?, bedroomCount = ?, bathroomCount = ?, amenities = ?, noOfGarage = ?, garageSize = ?, yearBuilt = ?, basement = ?, basementDescription = ?, roofingDescription = ?, additionalRemarks = ?, availabilityStatus = ?, nameOfDeveloper = ?, nameOfProject = ?, datetime = ?, address = ?, city = ?, country = ?, zipCode = ? WHERE propertyID = ?";
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

	public String insertProperty(Map<String, Object> request, int userID) {
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
			pstmt.setInt(17, userID);
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
	
	public List<Property> filterProperty(int min, int max, String frequest2, String frequest3, String frequest4, String frequest5, String frequest6, int frequest7, String frequest8, String frequest9, int size){
		List<Property> propertyList = new ArrayList<Property>();
		List<String> amenities = new ArrayList<String>();
		Connection myConn = DBProperty.getConnection();
		PreparedStatement fpstmt = null;
		String bedroom = "", bathroom = "", noOfGarage ="",garageSize="",yearBuilt="",totalArea="";
		if (frequest2.equals("")) {bedroom = "bedroomCount LIKE ";} else {bedroom = "bedroomCount = ";}
		if (frequest3.equals("")) {bathroom = "bathroomCount LIKE ";} else {bathroom = "bathroomCount = ";}
		if (frequest4.equals("")) {noOfGarage = "noOfGarage LIKE ";} else {noOfGarage = "noOfGarage = ";}
		if (frequest5.equals("")) {garageSize = "garageSize LIKE ";} else {garageSize = "garageSize = ";}
		if (frequest6.equals("")) {yearBuilt = "yearBuilt LIKE ";} else {yearBuilt = "yearBuilt = ";}
		if (frequest8.equals("")) {totalArea = "totalArea LIKE ";} else {totalArea = "totalArea = ";}
		
		String filter = "SELECT * FROM properties.property WHERE sellingPrice >= ? AND sellingPrice <= ? AND "+bedroom+"? AND "+bathroom+" ? AND "+noOfGarage+" ?  AND "+garageSize+" ? AND "+yearBuilt+" ? AND basement = ? AND "+totalArea+" ? AND amenities LIKE ? ";
		
		
		for (int i=0; i < size-1; i++) {
			filter += "AND amenities LIKE ?"; 
		}
		
		try {
			fpstmt = myConn.prepareStatement(filter);
			fpstmt.setInt(1, min);
			fpstmt.setInt(2, max);
			if (frequest2.equals("")) {	//bedroom
				fpstmt.setString(3, "%");
			} else {
				fpstmt.setString(3, frequest2);
			}
			//fpstmt.setInt(5, frequest3);
			if (frequest3.equals("")) { //bathroom
				fpstmt.setString(4, "%");
			} else {
				fpstmt.setString(4, frequest3);
			}
			//fpstmt.setDouble(6, frequest4); no of garage
			if (frequest4.equals("")) {
				fpstmt.setString(5, "%");
			} else {
				fpstmt.setString(5, frequest4);
			}
			//fpstmt.setString(7, frequest5);garageSize
			if (frequest5.equals("")) { 
				fpstmt.setString(6, "%");
			} else {
				fpstmt.setString(6, frequest5);
			}
			//fpstmt.setInt(8, frequest6); yearBuilt
			if (frequest6.equals("")) { 
				fpstmt.setString(7, "%");
			} else {
				fpstmt.setString(7, frequest6);
			}
			fpstmt.setInt(8, frequest7);
			//fpstmt.setDouble(10, frequest8);totalArea
			if (frequest8.equals("")) { 
				fpstmt.setString(9, "%");
			} else {
				fpstmt.setString(9, frequest8);
			}
			if (frequest9.contains("Attic")) {amenities.add("Attic");}
			if (frequest9.contains("Wine Cellar")) {amenities.add("Wine cellar");}
			if (frequest9.contains("Fire Place")) {amenities.add("Fire Place");}
			if (frequest9.contains("Backyard")) {amenities.add("Backyard");}
			if (frequest9.contains("Sprinklers")) {amenities.add("Sprinklers");}
			if (frequest9.contains("Laundry")) {amenities.add("Laundry");}
			if (frequest9.contains("Private space")) {amenities.add("Private space");}
			if (frequest9.contains("Gas heat")) {amenities.add("Gas heat");}
			if (frequest9.contains("Basketball court")) {amenities.add("Basketball court");}
			if (frequest9.contains("Lake view")) {amenities.add("Lake view");}
			if (frequest9.contains("Front yard")) {amenities.add("Front yard");}
			if (frequest9.contains("Washer and dryer")) {amenities.add("Washer and dryer");}
			if (frequest9.contains("Concierge")) {amenities.add("Concierge");}
			if (frequest9.contains("Storage")) {amenities.add("Storage");}
			if (frequest9.contains("Ocean view")) {amenities.add("Ocean view");}
			if (frequest9.contains("Gym")) {amenities.add("Gym");}
			if (frequest9.contains("Pet pound")) {amenities.add("Pet pound");}
			if (frequest9.contains("Pool")) {amenities.add("Pool");}
			if (frequest9.contains("Fenced yard")) {amenities.add("Fenced yard");}
			if (frequest9.contains("Deck")) {amenities.add("Deck");}
			if (frequest9.contains("Balcony")) {amenities.add("Balcony");}
			if (frequest9.contains("Doorman")) {amenities.add("Doorman");}
			if (frequest9.contains("Recreation area")) {amenities.add("Recreation area");}
			int j = 0;
			if (size > 0) {
			for (int i=10; i < size+10; i++) {
				fpstmt.setString(i, "%" + amenities.get(j) + "%");
				j++;
			}
			}
			if (size==0) {
				fpstmt.setString(10, "%");
			}
			ResultSet rs = fpstmt.executeQuery();
			
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
	
	
	public List<Property> compareProperty(int propertyID, int propertyID2) {
		Connection conn = DBProperty.getConnection();
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM property WHERE propertyID = ? OR propertyID = ?";
		
		ResultSet rs = null;
		List<Property> two = new ArrayList<Property>();
		try {

			if (conn != null) {
				int i = 1;

				pstmt = conn.prepareStatement(query);
				pstmt.setInt(i++, propertyID);
				pstmt.setInt(i++, propertyID2);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					Property p = new Property();
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
					two.add(p);
				}

				query = "UPDATE property SET clickCount = (SELECT clickCount WHERE propertyID = ?)+1 WHERE propertyID = ?";
				String query1 = "UPDATE property SET clickCount = (SELECT clickCount WHERE propertyID = ?)+1 WHERE propertyID = ?";

				int j = 1;
				int k = 1;
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(j++, propertyID);
				pstmt.setInt(j++, propertyID);
				int s = pstmt.executeUpdate();
				
				pstmt = conn.prepareStatement(query1);
				pstmt.setInt(k++, propertyID);
				pstmt.setInt(k++, propertyID);
				int t = pstmt.executeUpdate();
			}

		} catch (SQLException ex) {
			Logger.getLogger(PropertyDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBProperty.closeConnection(conn, pstmt);
		}
		return two;
	}
	
	
}
