package com.ssafy.member.dao;

import com.ssafy.member.model.MemberDto;
import util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {
    
    private static MemberDao instance = new MemberDaoImpl();
    
    private MemberDaoImpl() {}
    
    public static MemberDao getInstance() {
        return instance;
    }

    @Override
    public void insertMember(MemberDto memberDto) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "INSERT INTO members (member_id, name, nickname, password, phone_number, email, join_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberDto.getMemberId());
            pstmt.setString(2, memberDto.getName());
            pstmt.setString(3, memberDto.getNickname());
            pstmt.setString(4, memberDto.getPassword());
            pstmt.setString(5, memberDto.getPhoneNumber());
            pstmt.setString(6, memberDto.getEmail());
            pstmt.setTimestamp(7, Timestamp.valueOf(memberDto.getJoinDate()));
            pstmt.executeUpdate();
        } finally {
            DBUtil.getInstance().close(pstmt, conn);
        }
    }

    @Override
    public MemberDto getMemberById(String memberId) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        MemberDto memberDto = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "SELECT * FROM members WHERE member_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                memberDto = new MemberDto();
                memberDto.setMemberId(rs.getString("member_id"));
                memberDto.setName(rs.getString("name"));
                memberDto.setNickname(rs.getString("nickname"));
                memberDto.setPassword(rs.getString("password"));
                memberDto.setPhoneNumber(rs.getString("phone_number"));
                memberDto.setEmail(rs.getString("email"));
                memberDto.setJoinDate(rs.getTimestamp("join_date").toLocalDateTime());
            }
        } finally {
            DBUtil.getInstance().close(rs, pstmt, conn);
        }
        return memberDto;
    }

    @Override
    public List<MemberDto> getAllMembers() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<MemberDto> memberList = new ArrayList<>();
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "SELECT * FROM members";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                MemberDto memberDto = new MemberDto();
                memberDto.setMemberId(rs.getString("member_id"));
                memberDto.setName(rs.getString("name"));
                memberDto.setNickname(rs.getString("nickname"));
                memberDto.setPassword(rs.getString("password"));
                memberDto.setPhoneNumber(rs.getString("phone_number"));
                memberDto.setEmail(rs.getString("email"));
                memberDto.setJoinDate(rs.getTimestamp("join_date").toLocalDateTime());
                memberList.add(memberDto);
            }
        } finally {
            DBUtil.getInstance().close(rs, pstmt, conn);
        }
        return memberList;
    }

    @Override
    public void updateMember(MemberDto memberDto) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "UPDATE members SET name=?, nickname=?, password=?, phone_number=?, email=? WHERE member_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberDto.getName());
            pstmt.setString(2, memberDto.getNickname());
            pstmt.setString(3, memberDto.getPassword());
            pstmt.setString(4, memberDto.getPhoneNumber());
            pstmt.setString(5, memberDto.getEmail());
            pstmt.setString(6, memberDto.getMemberId());
            pstmt.executeUpdate();
        } finally {
            DBUtil.getInstance().close(pstmt, conn);
        }
    }

    @Override
    public void deleteMember(String memberId) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "DELETE FROM members WHERE member_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberId);
            pstmt.executeUpdate();
        } finally {
            DBUtil.getInstance().close(pstmt, conn);
        }
    }

    @Override
    public boolean checkDuplicateId(String memberId) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "SELECT COUNT(*) FROM members WHERE member_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } finally {
            DBUtil.getInstance().close(rs, pstmt, conn);
        }
        return false;
    }

    @Override
    public boolean checkDuplicateEmail(String email) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "SELECT COUNT(*) FROM members WHERE email=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } finally {
            DBUtil.getInstance().close(rs, pstmt, conn);
        }
        return false;
    }

    @Override
    public List<MemberDto> searchMembersByName(String name) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<MemberDto> memberList = new ArrayList<>();
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "SELECT * FROM members WHERE name LIKE ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + name + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                MemberDto memberDto = new MemberDto();
                memberDto.setMemberId(rs.getString("member_id"));
                memberDto.setName(rs.getString("name"));
                memberDto.setNickname(rs.getString("nickname"));
                memberDto.setPassword(rs.getString("password"));
                memberDto.setPhoneNumber(rs.getString("phone_number"));
                memberDto.setEmail(rs.getString("email"));
                memberDto.setJoinDate(rs.getTimestamp("join_date").toLocalDateTime());
                memberList.add(memberDto);
            }
        } finally {
            DBUtil.getInstance().close(rs, pstmt, conn);
        }
        return memberList;
    }
}