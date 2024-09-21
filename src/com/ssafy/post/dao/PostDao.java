package com.ssafy.post.dao;

import com.ssafy.post.model.PostDto;
import com.ssafy.post.model.PostsDto;


public interface PostDao {
    // 여행 CRUD
    // Create
    Integer createPost(PostDto postDto);

    // Read
    PostsDto searchPostsAll();
    PostsDto findByMemberId(Integer memberId);
    PostDto findById(Integer tripId);

    // Update
    void modifyPost(PostDto postDto);

    // Delete
    void deletePost(Integer postId);
}
