package com.ssafy.rating.dao;

import com.ssafy.attraction.model.AttractionDto;
import com.ssafy.member.model.MemberDto;
import com.ssafy.rating.model.RatingDto;
import com.ssafy.rating.model.RatingsDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBUtil;

public class RatingDaoImpl implements RatingDao {

    private static final RatingDaoImpl instance = new RatingDaoImpl();

    private RatingDaoImpl() {}

    public static RatingDaoImpl getInstance() {
        return instance;
    }

    @Override
    public Integer createRating(RatingDto ratingDto) {
        String sql = "INSERT INTO Rating (member_id, attraction_id, rate) VALUES (?, ?, ?)";

        try (Connection conn = DBUtil.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, ratingDto.getMemberId());
            pstmt.setInt(2, ratingDto.getAttractionId());
            pstmt.setInt(3, ratingDto.getRate());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                // 생성된 기본 키를 반환
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1);  // 생성된 평점 ID 반환
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;  // 실패 시 -1 반환
    }

    // 모든 평점 조회
    @Override
    public RatingsDto searchRatingsAll() {
        String sql = "SELECT r.id, r.rate, r.member_id, r.attraction_id, m.name AS member_name, a.title AS attraction_title " +
                "FROM Rating r " +
                "JOIN members m ON r.member_id = m.id " +
                "JOIN attractions a ON r.attraction_id = a.no";

        RatingsDto ratingsDto = new RatingsDto();

        try (Connection conn = DBUtil.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                RatingDto ratingDto = new RatingDto();
                ratingDto.setId(rs.getInt("id"));
                ratingDto.setRate(rs.getInt("rate"));

                // MemberDto 설정
                MemberDto memberDto = new MemberDto();
                memberDto.setId(rs.getInt("member_id"));
                memberDto.setName(rs.getString("member_name"));
                ratingDto.setMemberDto(memberDto);
                ratingDto.setMemberId(rs.getInt("member_id"));

                // AttractionDto 설정
                AttractionDto attractionDto = new AttractionDto();
                attractionDto.setId(rs.getInt("attraction_id"));
                attractionDto.setTitle(rs.getString("attraction_title"));
                ratingDto.setAttractionDto(attractionDto);
                ratingDto.setAttractionId(rs.getInt("attraction_id"));

                ratingsDto.addRating(ratingDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ratingsDto;
    }

    // 특정 회원의 평점 조회
    @Override
    public RatingsDto searchRatingsByMemberId(Integer memberId) {
        String sql = "SELECT r.id, r.rate, r.member_id, r.attraction_id, m.name AS member_name, a.title AS attraction_title " +
                "FROM Rating r " +
                "JOIN members m ON r.member_id = m.id " +
                "JOIN attractions a ON r.attraction_id = a.no " +
                "WHERE r.member_id = ?";

        RatingsDto ratingsDto = new RatingsDto();

        try (Connection conn = DBUtil.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, memberId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    RatingDto ratingDto = new RatingDto();
                    ratingDto.setId(rs.getInt("id"));
                    ratingDto.setRate(rs.getInt("rate"));

                    // MemberDto 설정
                    MemberDto memberDto = new MemberDto();
                    memberDto.setId(rs.getInt("member_id"));
                    memberDto.setName(rs.getString("member_name"));
                    ratingDto.setMemberDto(memberDto);
                    ratingDto.setMemberId(rs.getInt("member_id"));

                    // AttractionDto 설정
                    AttractionDto attractionDto = new AttractionDto();
                    attractionDto.setId(rs.getInt("attraction_id"));
                    attractionDto.setTitle(rs.getString("attraction_title"));
                    ratingDto.setAttractionDto(attractionDto);
                    ratingDto.setAttractionId(rs.getInt("attraction_id"));

                    ratingsDto.addRating(ratingDto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ratingsDto;
    }

    // 특정 관광지에 대한 평점 조회
    @Override
    public RatingsDto searchRatingsByAttractionId(Integer attractionId) {
        String sql = "SELECT r.id, r.rate, r.member_id, r.attraction_id, m.name AS member_name, a.title AS attraction_title " +
                "FROM Rating r " +
                "JOIN members m ON r.member_id = m.id " +
                "JOIN attractions a ON r.attraction_id = a.no " +
                "WHERE r.attraction_id = ?";

        RatingsDto ratingsDto = new RatingsDto();

        try (Connection conn = DBUtil.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, attractionId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    RatingDto ratingDto = new RatingDto();
                    ratingDto.setId(rs.getInt("id"));
                    ratingDto.setRate(rs.getInt("rate"));

                    // MemberDto 설정
                    MemberDto memberDto = new MemberDto();
                    memberDto.setId(rs.getInt("member_id"));
                    memberDto.setName(rs.getString("member_name"));
                    ratingDto.setMemberDto(memberDto);
                    ratingDto.setMemberId(rs.getInt("member_id"));

                    // AttractionDto 설정
                    AttractionDto attractionDto = new AttractionDto();
                    attractionDto.setId(rs.getInt("attraction_id"));
                    attractionDto.setTitle(rs.getString("attraction_title"));
                    ratingDto.setAttractionDto(attractionDto);
                    ratingDto.setAttractionId(rs.getInt("attraction_id"));

                    ratingsDto.addRating(ratingDto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ratingsDto;
    }

    // 특정 회원과 특정 관광지에 대한 평점 조회
    @Override
    public RatingDto searchRatingByMemberIdAndAttractionId(Integer memberId, Integer attractionId) {
        String sql = "SELECT r.id, r.rate, r.member_id, r.attraction_id, m.name AS member_name, a.title AS attraction_title " +
                "FROM Rating r " +
                "JOIN members m ON r.member_id = m.id " +
                "JOIN attractions a ON r.attraction_id = a.no " +
                "WHERE r.member_id = ? AND r.attraction_id = ?";

        RatingDto ratingDto = null;

        try (Connection conn = DBUtil.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, memberId);
            pstmt.setInt(2, attractionId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    ratingDto = new RatingDto();
                    ratingDto.setId(rs.getInt("id"));
                    ratingDto.setRate(rs.getInt("rate"));

                    // MemberDto 설정
                    MemberDto memberDto = new MemberDto();
                    memberDto.setId(rs.getInt("member_id"));
                    memberDto.setName(rs.getString("member_name"));
                    ratingDto.setMemberDto(memberDto);
                    ratingDto.setMemberId(rs.getInt("member_id"));

                    // AttractionDto 설정
                    AttractionDto attractionDto = new AttractionDto();
                    attractionDto.setId(rs.getInt("attraction_id"));
                    attractionDto.setTitle(rs.getString("attraction_title"));
                    ratingDto.setAttractionDto(attractionDto);
                    ratingDto.setAttractionId(rs.getInt("attraction_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ratingDto;
    }

    // Rating ID로 조회
    @Override
    public RatingDto searchRatingById(Integer id) {
        String sql = "SELECT r.id, r.rate, r.member_id, r.attraction_id, m.name AS member_name, a.title AS attraction_title " +
                "FROM Rating r " +
                "JOIN members m ON r.member_id = m.id " +
                "JOIN attractions a ON r.attraction_id = a.no " +
                "WHERE r.id = ?";

        RatingDto ratingDto = null;

        try (Connection conn = DBUtil.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    ratingDto = new RatingDto();
                    ratingDto.setId(rs.getInt("id"));
                    ratingDto.setRate(rs.getInt("rate"));

                    // MemberDto 설정
                    MemberDto memberDto = new MemberDto();
                    memberDto.setId(rs.getInt("member_id"));
                    memberDto.setName(rs.getString("member_name"));
                    ratingDto.setMemberDto(memberDto);
                    ratingDto.setMemberId(rs.getInt("member_id"));

                    // AttractionDto 설정
                    AttractionDto attractionDto = new AttractionDto();
                    attractionDto.setId(rs.getInt("attraction_id"));
                    attractionDto.setTitle(rs.getString("attraction_title"));
                    ratingDto.setAttractionDto(attractionDto);
                    ratingDto.setAttractionId(rs.getInt("attraction_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ratingDto;
    }

    @Override
    public void modifyRating(RatingDto ratingDto) {
        String sql = "UPDATE Rating SET rate = ?, member_id = ?, attraction_id = ? WHERE id = ?";

        try (Connection conn = DBUtil.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ratingDto.getRate());
            pstmt.setInt(2, ratingDto.getMemberId());
            pstmt.setInt(3, ratingDto.getAttractionId());
            pstmt.setInt(4, ratingDto.getId());  // 수정할 평점 ID

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteRating(Integer ratingId) {
        String sql = "DELETE FROM Rating WHERE id = ?";

        try (Connection conn = DBUtil.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ratingId);  // 삭제할 평점 ID

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

