package com.ssafy.rating.model;

import java.util.ArrayList;
import java.util.List;

public class RatingsDto {
    private List<RatingDto> ratings = new ArrayList<>();

    public RatingsDto(List<RatingDto> ratings) {
        this.ratings = ratings;
    }

    public RatingsDto() {}

    public List<RatingDto> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingDto> ratings) {
        this.ratings = ratings;
    }

    public void addRating(RatingDto ratingDto) {
        ratings.add(ratingDto);
    }
}
