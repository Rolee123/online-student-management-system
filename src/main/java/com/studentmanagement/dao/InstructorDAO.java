package com.studentmanagement.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.studentmanagement.model.Instructor;
import com.studentmanagement.util.DBUtil;

public class InstructorDAO {
    private static final Logger LOGGER = Logger.getLogger(InstructorDAO.class.getName());

    public boolean isEmailExists(String email) {
        String query = "SELECT id FROM Users WHERE email = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error checking email existence", e);
            return false;
        }
    }

    public boolean addInstructor(String name, String email) {
        String query = "INSERT INTO Users (name, email, password, role, password_generated, created_at, updated_at) VALUES (?, ?, ?, ?, ?, GETDATE(), GETDATE())";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, "password123"); // Default password
            stmt.setString(4, "INSTRUCTOR");  // Assign role as Instructor
            stmt.setInt(5, 0); // Indicates password is system-generated

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error adding instructor", e);
            return false;
        }
    }

    public List<Instructor> getAllInstructors() {
        List<Instructor> instructors = new ArrayList<>();
        String query = "SELECT id, name, email FROM Users WHERE role = 'INSTRUCTOR'";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                instructors.add(new Instructor(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error fetching instructors", e);
        }
        return instructors;
    }
    
    // Method to update Instructor details
    public boolean updateInstructor(Instructor instructor) {
        boolean updated = false;
        String sql = "UPDATE Users SET name = ?, email = ? WHERE id = ?";
        
        try (Connection conn = DBUtil.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, instructor.getName());
            stmt.setString(2, instructor.getEmail());
            stmt.setInt(3, instructor.getId());
            
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                updated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return updated;
    }

    // Method to delete Instructor by ID and Email
    public boolean deleteInstructor(int id) {
        boolean deleted = false;
        String sql = "DELETE FROM Users WHERE id = ?";
        
        try (Connection conn = DBUtil.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                deleted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return deleted;
    }
}
