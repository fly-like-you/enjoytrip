package com.ssafy.attraction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.attraction.model.AttractionDto;

import util.DBUtil;

public class AttractionDaoImpl implements AttractionDao {
	private static AttractionDao attractionDao = new AttractionDaoImpl();
	
	private AttractionDaoImpl() {}

	public static AttractionDao getAttractionDao() {
		return attractionDao;
	}
	
	public List<AttractionDto> searchAttractionsAll() {
	    String sql = 
	              "SELECT title, c.content_type_name, first_image1, latitude, longitude, addr1 "
	            + "FROM attractions a INNER JOIN contenttypes c "
	            + "ON a.content_type_id = c.content_type_id;";
	    
	    List<AttractionDto> list = new ArrayList<>();
	    
	    try (Connection conn = DBUtil.getInstance().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery()) {
	        
	        while (rs.next()) {
	            String title = rs.getString("title");
	            String contentType = rs.getString("content_type_name");
	            String imageUrl = rs.getString("first_image1");
	            double latitude = rs.getDouble("latitude");
	            double longitude = rs.getDouble("longitude");
	            String address = rs.getString("addr1");

	            list.add(new AttractionDto(title, address, contentType, imageUrl, latitude, longitude));
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}


}
