package com.ssafy.rating.dao;

import com.ssafy.rating.model.RatingDto;
import com.ssafy.rating.model.RatingsDto;

public interface RatingDao {
    // 평점 CRUD
    /*            CREATE           */
    Integer createRating(RatingDto ratingDto);


    /*            READ           */
    RatingsDto searchRatingsAll();

    RatingsDto searchRatingsByMemberId(Integer memberId);

    RatingsDto searchRatingsByAttractionId(Integer attractionId);

    RatingDto searchRatingByMemberIdAndAttractionId(Integer memberId, Integer attractionId);

    RatingDto searchRatingById(Integer id);

    /*            UPDATE           */
    void modifyRating(RatingDto ratingDto);

    /*            DELETE           */
    void deleteRating(Integer ratingId);
}
