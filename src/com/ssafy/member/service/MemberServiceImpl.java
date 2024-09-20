package com.ssafy.member.service;

import java.util.List;

import com.ssafy.member.dao.MemberDaoImpl;
import com.ssafy.member.model.MemberDto;
public class MemberServiceImpl implements MemberService{

final static MemberServiceImpl instance = new MemberServiceImpl();
	
	public static MemberServiceImpl getMemberService() {
		return instance;
	}
	
	private MemberServiceImpl() {}
	
	@Override
	public List<MemberDto> searchMembersAll() {
		return MemberDaoImpl.getMemberDao().searchMembersAll();
	}
}
