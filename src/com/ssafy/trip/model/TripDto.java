package com.ssafy.trip.model;

import java.time.LocalDate;

public class TripDto {
	// pk
	private Integer id;
	
	private String name;
	
	// 외래키
	private Integer memberId;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate createdAt;
	
	public TripDto() {}

	public TripDto(String name, Integer memberId, LocalDate startDate, LocalDate endDate, LocalDate createdAt) {
		this.name = name;
		this.memberId = memberId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdAt = createdAt;
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getMemberId() {
		return memberId;
	}



	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}



	public LocalDate getStartDate() {
		return startDate;
	}



	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}



	public LocalDate getEndDate() {
		return endDate;
	}



	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}



	public LocalDate getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	

	
}
