package com.ssafy.post.dao;

import com.ssafy.post.model.PostDto;
import com.ssafy.post.model.PostsDto;
import com.ssafy.trip.model.TripDto;
import com.ssafy.trip.model.TripsDto;

public interface PostDao {
    // 여행 CRUD
    // Create
    void createPost(PostDto postDto);

    // Read
    PostsDto searchPostsAll();
    PostsDto findByMemberId(Integer memberId);
    PostDto findById(Integer tripId);

    // Update
    void modifyPost(PostDto postDto);

    // Delete
    void deletePost(Integer postId);
}
