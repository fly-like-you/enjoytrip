package com.ssafy.member.model;

public class MemberDto {
/*
 * 회원 아이디
 * 이름
 * 닉네임
 * 가입일
 * 전화번호
 * 이메일
 * 
 * */
	private String member_id;
	private String name;
	private String nickname;
	private int password;
	private int phone_number;
	private String email;
	
	public MemberDto() {}
	

	public MemberDto(String member_id, String name, String nickname, int password, int phone_number, String email) {
		super();
		this.member_id = member_id;
		this.name = name;
		this.nickname = nickname;
		this.password = password;
		this.phone_number = phone_number;
	}


	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	@Override
	public String toString() {
		return "MemberDto [member_id=" + member_id + ", name=" + name + ", nickname=" + nickname + ", phone_number="
				+ phone_number + ", email=" + email + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	
}
