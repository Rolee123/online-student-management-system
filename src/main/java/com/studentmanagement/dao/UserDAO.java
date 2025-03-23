package com.studentmanagement.dao;

import com.studentmanagement.model.User;
import com.studentmanagement.util.DBUtil;
import java.sql.*;

public class UserDAO {

    public User getUserByEmail(String email) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM Users WHERE email = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getString("role")
                );
            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return null;
    }
}
