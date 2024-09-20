package com.ssafy.trip.dao;

import com.ssafy.trip.model.TripDto;
import com.ssafy.trip.model.TripsDto;

public interface TripDao {
	// 여행 CRUD
	// Read
	TripsDto searchTripsAll();
	TripsDto findByMemberId(Integer memberId);
	TripDto findById(Integer tripId);
	
	// Create
	void createTrip(TripDto tripDto);
	
	// Update
	void modifyTrip(TripDto tripDto);
	
	// Delete
	void deleteTrip(Integer tripId);
}
