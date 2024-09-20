package com.ssafy.attraction.model;

public class AttractionDto {
/*
관광지 제목
관광지 주소
관광지 타입
관광지 이미지
관광지 위도 경도
 * */
	private String title;
	private String addr;
	private String type;
	private String imgUrl;
	private long lat;
	private long lng;
	
	public AttractionDto() {}
	
	public AttractionDto(String title, String addr, String type, String imgUrl, long lat, long lng) {
		super();
		this.title = title;
		this.addr = addr;
		this.type = type;
		this.imgUrl = imgUrl;
		this.lat = lat;
		this.lng = lng;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public long getLat() {
		return lat;
	}
	public void setLat(long lat) {
		this.lat = lat;
	}
	
	public long getLng() {
		return lng;
	}
	public void setLng(long lng) {
		this.lng = lng;
	}
	
	@Override
	public String toString() {
		return "AttractionDto [title=" + title + ", addr=" + addr + ", type=" + type + ", imgUrl=" + imgUrl + ", lat="
				+ lat + ", lng=" + lng + "]";
	}

	
}
