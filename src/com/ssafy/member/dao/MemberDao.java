package com.ssafy.member.dao;

import com.ssafy.member.model.MemberDto;
import java.sql.SQLException;
import java.util.List;

public interface MemberDao {
    void insertMember(MemberDto memberDto) throws SQLException;
    MemberDto getMemberById(String memberId) throws SQLException;
    List<MemberDto> getAllMembers() throws SQLException;
    void updateMember(MemberDto memberDto) throws SQLException;
    void deleteMember(String memberId) throws SQLException;
    
    // 추가 기능
    boolean checkDuplicateId(String memberId) throws SQLException;
    boolean checkDuplicateEmail(String email) throws SQLException;
    List<MemberDto> searchMembersByName(String name) throws SQLException;
}