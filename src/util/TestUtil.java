package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUtil {
    public static Integer createTempUser() {
        String sql =
                "INSERT INTO members (name, password, nickname, member_id, phone_number, email) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (
                Connection conn = DBUtil.getInstance().getConnection();
                PreparedStatement pstmt = conn.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS
                )
        ) {
            // 더미 데이터 설정
            pstmt.setString(1, "홍길동"); // name
            pstmt.setString(2, "password123"); // password
            pstmt.setString(3, "Johnny"); // nickname
            pstmt.setString(4, "member001"); // member_id
            pstmt.setInt(5, 1234567890); // phone_number
            pstmt.setString(6, "홍길동@example.com"); // email

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                // 생성된 기본 키를 받아옴
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) return rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void deleteTempUser(Integer userId) {
        String sql =
              "DELETE FROM members\n"
            + "WHERE id = ?;";

        try (
                Connection conn = DBUtil.getInstance().getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
