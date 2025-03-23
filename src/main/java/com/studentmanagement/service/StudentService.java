package com.studentmanagement.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.studentmanagement.dao.StudentDAO;
import com.studentmanagement.model.Student;

public class StudentService {
    private static final Logger LOGGER = Logger.getLogger(StudentService.class.getName());
    private final StudentDAO studentDao = new StudentDAO();

    public boolean addStudent(String name, String email) {
        LOGGER.log(Level.INFO, "Attempting to add student: {0}, Email: {1}", new Object[]{name, email});

        if (studentDao.isEmailExists(email)) {
            LOGGER.log(Level.WARNING, "Student with email {0} already exists.", email);
            return false; // Email already exists
        }

        boolean success = studentDao.addStudent(name, email);
        if (success) {
            LOGGER.log(Level.INFO, "Student {0} added successfully.", name);
        } else {
            LOGGER.log(Level.SEVERE, "Failed to add student: {0}", name);
        }
        return success;
    }

    public List<Student> getAllStudents() {
        LOGGER.log(Level.INFO, "Fetching all students.");
        List<Student> students = studentDao.getAllStudents();
        LOGGER.log(Level.INFO, "Fetched {0} students.", students.size());
        return students;
    }

    // Method to update instructor details
    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

	public boolean deleteStudent(int id) {
        return studentDao.deleteStudent(id);
	}
}
