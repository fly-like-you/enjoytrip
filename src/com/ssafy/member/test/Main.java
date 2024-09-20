package com.ssafy.member.test;

import java.util.List;


import com.ssafy.member.model.MemberDto;
import com.ssafy.member.service.MemberService;
import com.ssafy.member.service.MemberServiceImpl;
public class Main {
	
	static MemberService memberService = MemberServiceImpl.getMemberService();
	public static void main(String[] args) {
	
		List<MemberDto> list = memberService.searchMembersAll();
		
		System.out.println("********** 글목록(전체) **********");
		for(MemberDto attr : list) {
			System.out.println(attr);
		}
	}
	
}

