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
	
	@Override
	public List<AttractionDto> searchAttractionsAll() {
		List<AttractionDto> list = new ArrayList<AttractionDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = 
				  "SELECT title, c.content_type_name, first_image1, latitude, longitude, addr1\r\n"
				+ "FROM attractions a INNER JOIN contenttypes c\r\n"
				+ "ON a.content_type_id = c.content_type_id;";
		
		try {
			conn = DBUtil.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String t = rs.getString("title");
				String type = rs.getString("content_type_name");
				String url = rs.getString("first_image1");
				long lat = rs.getLong("latitude");
				long lng = rs.getLong("longitude");
				String addr = rs.getString("addr1");

				list.add(new AttractionDto(t, addr, type, url, lat, lng));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//		END
		return list;
	}

}
