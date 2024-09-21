package com.ssafy.trip.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.trip.model.TripDto;
import com.ssafy.trip.model.TripsDto;

import util.DBUtil;


public class TripDaoImpl implements TripDao {
	private static final TripDaoImpl tripDao = new TripDaoImpl();

	private TripDaoImpl() {}

	public static TripDaoImpl getTripDao() {
		return tripDao;
	}

	@Override
	public void createTrip(TripDto tripDto) {
		String sql =
				"INSERT INTO trips(trip_name, start_date, end_date, created_at, member_id)\n"
			  + "VALUE (?, ?, ?, ?, ?)";
		try (
				Connection conn = DBUtil.getInstance().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, tripDto.getName());
			pstmt.setDate(2, tripDto.getStartDate());
			pstmt.setDate(3, tripDto.getEndDate());
			pstmt.setDate(4, tripDto.getCreatedAt());
			pstmt.setInt(5, tripDto.getMemberId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public TripsDto searchTripsAll() {
	    String sql =
	    		  "SELECT id, trip_name, member_id, start_date, end_date, created_at\r\n"
	    		+ "FROM trips";

	    TripsDto trips = new TripsDto();

	    try (Connection conn = DBUtil.getInstance().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery()) {

	        while (rs.next()) {
	        	Integer id = rs.getInt("id");
	        	String name = rs.getString("trip_name");
	        	Integer memberId = rs.getInt("member_id");
	        	Date startDate = rs.getDate("start_date");
	        	Date endDate = rs.getDate("end_date");
	        	Date createAt = rs.getDate("created_at");

	        	trips.addTrip(new TripDto(id, name, memberId, startDate, endDate, createAt));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return trips;
	}

	@Override
	public TripDto findById(Integer tripId) {
		String sql =
				  "SELECT id, trip_name, start_date, end_date, created_at, member_id\r\n"
				+ "FROM trips\r\n"
				+ "WHERE member_id = ?";

		TripDto trip = new TripDto();

		try (
				Connection conn = DBUtil.getInstance().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1,  tripId);

			try (
					ResultSet rs = pstmt.executeQuery();
			) {
				if (rs.next()) {
					Integer id = rs.getInt("id");
					Integer memberId = rs.getInt("member_id");
					String name = rs.getString("trip_name");
					Date startDate = rs.getDate("start_date");
					Date endDate = rs.getDate("end_date");
					Date createAt = rs.getDate("created_at");

					trip = new TripDto(id, name, memberId, startDate, endDate, createAt);
				}
				return trip;
			}

		}  catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	// 멤버의 고유식별번호로 검색하기 (아이디X)
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
		        	String name = rs.getString("trip_name");
		        	Date startDate = rs.getDate("start_date");
		        	Date endDate = rs.getDate("end_date");
					Date createAt = rs.getDate("created_at");

					trips.addTrip(new TripDto(id, name, memberId, startDate, endDate, createAt));
		        }
				return trips;
			}

		}  catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void modifyTrip(TripDto tripDto) {
		String sql =
				  "UPDATE trips\n"
				+ "SET trip_name = ?,\n"
				+ "	   start_date = ?,\n"
				+ "    end_date = ?\n"
				+ "WHERE id = ?";

		try (
				Connection conn = DBUtil.getInstance().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, tripDto.getName());
			pstmt.setDate(2, tripDto.getStartDate());
			pstmt.setDate(3, tripDto.getEndDate());
			pstmt.setInt(4, tripDto.getId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTrip(Integer tripId) {
		String sql =
				  "DELETE FROM trips\n"
				+ "WHERE id = ?;";

		try (
				Connection conn = DBUtil.getInstance().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1, tripId);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

