package com.studentmanagement.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.studentmanagement.dao.InstructorDAO;
import com.studentmanagement.model.Instructor;

public class InstructorService {
    private static final Logger LOGGER = Logger.getLogger(StudentService.class.getName());
    private final InstructorDAO instructorDAO = new InstructorDAO();

    public boolean addInstructor(String name, String email) {
        LOGGER.log(Level.INFO, "Attempting to add instructor: {0}, Email: {1}", new Object[]{name, email});

        if (instructorDAO.isEmailExists(email)) {
            LOGGER.log(Level.WARNING, "Instructor with email {0} already exists.", email);
            return false; // Email already exists
        }

        boolean success = instructorDAO.addInstructor(name, email);
        if (success) {
            LOGGER.log(Level.INFO, "Instructor {0} added successfully.", name);
        } else {
            LOGGER.log(Level.SEVERE, "Failed to add instructor: {0}", name);
        }
        return success;
    }

    public List<Instructor> getAllInstructors() {
        LOGGER.log(Level.INFO, "Fetching all instructors.");
        List<Instructor> instructors = instructorDAO.getAllInstructors();
        LOGGER.log(Level.INFO, "Fetched {0} instructors.", instructors.size());
        return instructors;
    }

    // Method to update instructor details
    public boolean updateInstructor(Instructor instructor) {
        return instructorDAO.updateInstructor(instructor);
    }

	public boolean deleteInstructor(int id) {
        return instructorDAO.deleteInstructor(id);
	}
}
