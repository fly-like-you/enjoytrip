package com.ssafy.rating.model;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.member.model.MemberDto;

public class RatingDto {
    private Integer id;
    private Integer memberId;
    private MemberDto memberDto;
    private Integer attractionId;
    private AttractionDto attractionDto;
    private Integer rate;

    public RatingDto() {}

    public MemberDto getMemberDto() {
        return memberDto;
    }

    public void setMemberDto(MemberDto memberDto) {
        this.memberDto = memberDto;
    }

    public AttractionDto getAttractionDto() {
        return attractionDto;
    }

    public void setAttractionDto(AttractionDto attractionDto) {
        this.attractionDto = attractionDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(Integer attractionId) {
        this.attractionId = attractionId;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "RatingDto{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", memberDto=" + memberDto +
                ", attractionId=" + attractionId +
                ", attractionDto=" + attractionDto +
                ", rate=" + rate +
                '}';
    }
}
