package com.ssafy.member.service;

import com.ssafy.member.dao.MemberDao;
import com.ssafy.member.dao.MemberDaoImpl;
import com.ssafy.member.model.MemberDto;

import java.sql.SQLException;
import java.util.List;

public class MemberServiceImpl implements MemberService {
    
    private MemberDao memberDao;
    
    public MemberServiceImpl() {
        this.memberDao = MemberDaoImpl.getInstance();
    }

    @Override
    public void registerMember(MemberDto memberDto) throws SQLException {
        if (isDuplicateId(memberDto.getMemberId())) {
            throw new SQLException("이미 존재하는 아이디입니다.");
        }
        if (isDuplicateEmail(memberDto.getEmail())) {
            throw new SQLException("이미 존재하는 이메일입니다.");
        }
        memberDao.insertMember(memberDto);
    }

    @Override
    public MemberDto getMember(String memberId) throws SQLException {
        return memberDao.getMemberById(memberId);
    }

    @Override
    public List<MemberDto> getAllMembers() throws SQLException {
        return memberDao.getAllMembers();
    }

    @Override
    public void updateMember(MemberDto memberDto) throws SQLException {
        if (!isMemberExist(memberDto.getMemberId())) {
            throw new SQLException("존재하지 않는 회원입니다.");
        }
        memberDao.updateMember(memberDto);
    }

    @Override
    public void deleteMember(String memberId) throws SQLException {
        if (!isMemberExist(memberId)) {
            throw new SQLException("존재하지 않는 회원입니다.");
        }
        memberDao.deleteMember(memberId);
    }

    @Override
    public boolean isDuplicateId(String memberId) throws SQLException {
        return memberDao.checkDuplicateId(memberId);
    }

    @Override
    public boolean isDuplicateEmail(String email) throws SQLException {
        return memberDao.checkDuplicateEmail(email);
    }

    @Override
    public List<MemberDto> searchMembersByName(String name) throws SQLException {
        return memberDao.searchMembersByName(name);
    }

    @Override
    public MemberDto login(String memberId, String password) throws SQLException {
        MemberDto member = memberDao.getMemberById(memberId);
        if (member != null && member.getPassword().equals(password)) {
            return member;
        }
        return null;
    }

    @Override
    public void changePassword(String memberId, String oldPassword, String newPassword) throws SQLException {
        MemberDto member = memberDao.getMemberById(memberId);
        if (member == null) {
            throw new SQLException("존재하지 않는 회원입니다.");
        }
        if (!member.getPassword().equals(oldPassword)) {
            throw new SQLException("기존 비밀번호가 일치하지 않습니다.");
        }
        member.setPassword(newPassword);
        memberDao.updateMember(member);
    }

    @Override
    public boolean isMemberExist(String memberId) throws SQLException {
        return memberDao.getMemberById(memberId) != null;
    }
}