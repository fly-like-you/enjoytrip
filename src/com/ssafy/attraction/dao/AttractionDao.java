package com.ssafy.attraction.dao;

import java.util.List;

import com.ssafy.attraction.model.AttractionDto;

public interface AttractionDao {
	List<AttractionDto> searchAttractionsAll();
}
