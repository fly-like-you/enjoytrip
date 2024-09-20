package com.ssafy.trip.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.ssafy.trip.model.TripDto;
import com.ssafy.trip.model.TripsDto;

import dto.ProductDto;
import util.DBUtil;


public class TripDaoImpl implements TripDao {
	private static TripDaoImpl tripDao = new TripDaoImpl();
	
	private TripDaoImpl() {}

	public static TripDaoImpl getTripDao() {
		return tripDao;
	}
	
	@Override
	public TripsDto searchTripsAll() {
	    String sql = 
	    		  "SELECT id, trip_name, member_id, start_date, end_date, create_at\r\n"
	    		+ "FROM trips";
	    
	    TripsDto trips = new TripsDto();
	    
	    try (Connection conn = DBUtil.getInstance().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery()) {
	        
	        while (rs.next()) {
	        	Integer id = rs.getInt("id");
	        	String name = rs.getString("name");
	        	Integer memberId = rs.getInt("member_id");
	        	Date startDate = rs.getDate("start_date");
	        	Date endDate = rs.getDate("end_date");
	        	Date createAt = rs.getDate("createAt");
	        	
	        	trips.addTrip(new TripDto(id, name, memberId, startDate, endDate, createAt));
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return trips;
	}

	@Override
	public TripsDto findByMemberId(Integer memberId) {
	    String sql = 
	    		    "SELECT id, trip_name, start_date, end_date, create_at, member_id\r\n"
	    		  + "FROM trips\r\n"
	    		  + "WHERE member_id = ?";
	    
	    TripsDto trips = new TripsDto();
	    
		try (
			Connection conn = DBUtil.getInstance().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1,  memberId);
			
			try (
					ResultSet rs = pstmt.executeQuery();		
					) {
		        while (rs.next()) {
		        	Integer id = rs.getInt("id");
		        	String name = rs.getString("name");
		        	Date startDate = rs.getDate("start_date");
		        	Date endDate = rs.getDate("end_date");
		        	Date createAt = rs.getDate("createAt");
		        	
		        	trips.addTrip(new TripDto(id, name, memberId, startDate, endDate, createAt));
		        }
				return null;
			}
			
		}
	}

	@Override
	public void createTrip(TripDto tripDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyTrip(TripDto tripDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTrip(Integer tripId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TripDto findById(Integer tripId) {
		// TODO Auto-generated method stub
		return null;
	}

}

