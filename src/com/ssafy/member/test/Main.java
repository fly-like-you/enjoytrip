package com.ssafy.member.test;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.attraction.service.AttractionService;
import com.ssafy.attraction.service.AttractionServiceImpl;
import java.util.List;


import com.ssafy.member.model.MemberDto;
import com.ssafy.member.service.MemberService;
import com.ssafy.member.service.MemberServiceImpl;
public class Main {
	
//	static MemberService memberService = MemberServiceImpl.getMemberService();
	static AttractionService attractionService = AttractionServiceImpl.getBoardService();
	public static void main(String[] args) {

		List<AttractionDto> list = attractionService.searchAttractionsAll();

		System.out.println("********** 글목록(전체) **********");
		for(AttractionDto attr : list) {
			System.out.println(attr);
		}
	}
	
}

