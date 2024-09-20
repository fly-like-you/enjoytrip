package com.ssafy.trip.dao;

import com.ssafy.attraction.dao.AttractionDao;
import com.ssafy.attraction.dao.AttractionDaoImpl;
import com.ssafy.trip.model.TripDto;
import com.ssafy.trip.model.TripsDto;

public class TripDaoImpl implements TripDao {
	private static TripDaoImpl tripDao = new TripDaoImpl();
	
	private TripDaoImpl() {}

	public static TripDaoImpl getTripDao() {
		return tripDao;
	}
	@Override
	public TripsDto searchTripsAll() {
		return null;
	}

	@Override
	public TripsDto findByMemberId(Integer memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createTrip(TripDto tripDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyTrip(TripDto tripDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTrip(Integer tripId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TripDto findById(Integer tripId) {
		// TODO Auto-generated method stub
		return null;
	}

}
