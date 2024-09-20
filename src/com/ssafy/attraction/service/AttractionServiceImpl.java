package com.ssafy.attraction.service;

import java.util.List;

import com.ssafy.attraction.dao.AttractionDaoImpl;
import com.ssafy.attraction.model.AttractionDto;
public class AttractionServiceImpl implements AttractionService{

	final static AttractionServiceImpl instance = new AttractionServiceImpl();
	
	public static AttractionServiceImpl getBoardService() {
		return instance;
	}
	
	private AttractionServiceImpl() {}
	
	@Override
	public List<AttractionDto> searchAttractionsAll() {
		return AttractionDaoImpl.getAttractionDao().searchAttractionsAll();
	}

}
