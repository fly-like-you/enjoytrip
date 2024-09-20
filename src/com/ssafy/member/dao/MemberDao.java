package com.ssafy.member.dao;

import java.util.List;

import com.ssafy.member.model.MemberDto;

public interface MemberDao {
	List<MemberDto> searchMembersAll();
}
