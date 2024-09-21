package com.ssafy.member.model;

import java.time.LocalDateTime;

public class MemberDto {
    private String memberId;
    private String name;
    private String nickname;
    private String password;
    private String phoneNumber;
    private String email;
    private LocalDateTime joinDate;

    public MemberDto() {}

    public MemberDto(String memberId, String name, String nickname, String password, 
                     String phoneNumber, String email, LocalDateTime joinDate) {
        this.memberId = memberId;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.joinDate = joinDate;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "MemberDto [memberId=" + memberId + ", name=" + name + ", nickname=" + nickname +
               ", phoneNumber=" + phoneNumber + ", email=" + email + ", joinDate=" + joinDate + "]";
    }
}