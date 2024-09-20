package com.ssafy.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.member.model.MemberDto;

import util.DBUtil;

public class MemberDaoImpl implements MemberDao {

private static MemberDao memberDao = new MemberDaoImpl();
	
	private MemberDaoImpl() {}

	public static MemberDao getMemberDao() {
		return memberDao;
	}
	
	@Override
	public List<MemberDto> searchMembersAll() {
		List<MemberDto> list = new ArrayList<MemberDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = 
				  "SELECT m.member_id,name, nickname,password,phone_number,email\r\n"
				+ "FROM Members m INNER Join Favoriteattractions favA\r\n"
				+ "ON m.id = favA.member_id\r\n"
				+ "INNER Join TouristAttractions T\r\n"
				+ "ON favA.tourist_id = T.id";
		
		
		try {
			conn = DBUtil.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("m.member_id");
				String name = rs.getString("name");
				String nickname = rs.getString("nickname");
				int pwd = rs.getInt("password");
				int phoneNum = rs.getInt("phone_number");
				String eamil = rs.getString("email");
				
				

				list.add(new MemberDto(id, name , nickname, pwd, phoneNum, eamil));
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
