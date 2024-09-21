package com.ssafy.member.service;

import com.ssafy.member.model.MemberDto;
import java.sql.SQLException;
import java.util.List;

public interface MemberService {
    
    // 회원 가입
    void registerMember(MemberDto memberDto) throws SQLException;
    
    // 회원 정보 조회
    MemberDto getMember(String memberId) throws SQLException;
    
    // 모든 회원 조회
    List<MemberDto> getAllMembers() throws SQLException;
    
    // 회원 정보 수정
    void updateMember(MemberDto memberDto) throws SQLException;
    
    // 회원 탈퇴
    void deleteMember(String memberId) throws SQLException;
    
    // 아이디 중복 체크
    boolean isDuplicateId(String memberId) throws SQLException;
    
    // 이메일 중복 체크
    boolean isDuplicateEmail(String email) throws SQLException;
    
    // 이름으로 회원 검색
    List<MemberDto> searchMembersByName(String name) throws SQLException;
    
    // 로그인
    MemberDto login(String memberId, String password) throws SQLException;
    
    // 비밀번호 변경
    void changePassword(String memberId, String oldPassword, String newPassword) throws SQLException;
    
    // 회원 존재 여부 확인
    boolean isMemberExist(String memberId) throws SQLException;
}