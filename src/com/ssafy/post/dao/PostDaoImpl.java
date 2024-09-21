package com.ssafy.post.dao;

import com.ssafy.post.model.PostDto;
import com.ssafy.post.model.PostsDto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBUtil;

public class PostDaoImpl implements PostDao {
    private static final PostDaoImpl postDao = new PostDaoImpl();

    private PostDaoImpl() {}

    public static PostDaoImpl getPostDao() {
        return postDao;
    }

    @Override
    public void createPost(PostDto postDto) {
        String sql =
                  "INSERT INTO trips(title, content, created_at, updated_at, member_id) \n"
                + "VALUE (?, ?, ?, ?, ?);";
        try (
                Connection conn = DBUtil.getInstance().getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, postDto.getTitle());
            pstmt.setString(2, postDto.getContent());
            pstmt.setDate(3, postDto.getCreatedAt());
            pstmt.setDate(4, postDto.getUpdatedAt());
            pstmt.setInt(5, postDto.get());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PostsDto searchPostsAll() {
        String sql =
                "SELECT p.id, title, content, created_at, updated_at, m.nickname\n"
              + "FROM posts p INNER JOIN members m\n"
              + "ON p.member_id = m.id\n";

        PostsDto posts = new PostsDto();

        try (Connection conn = DBUtil.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("title");
                String author = rs.getString("nickname");
                String content = rs.getString("content");
                Date createdAt = rs.getDate("created_at");
                Date updatedAt = rs.getDate("updated_at");

                posts.addPost(new PostDto(id, name, author, content, createdAt, updatedAt));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return posts;
    }

    @Override
    public PostsDto findByMemberId(Integer memberId) {
        return null;
    }

    @Override
    public PostDto findById(Integer tripId) {
        return null;
    }

    @Override
    public void modifyPost(PostDto postDto) {

    }

    @Override
    public void deletePost(Integer postId) {

    }
}
