package com.studentmanagement.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentmanagement.model.Student;
import com.studentmanagement.service.StudentService;

@WebServlet("/EditStudentServlet")
public class EditStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        studentService = new StudentService(); // Initialize service layer
    }

    // Method to handle POST requests for updating instructor details
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        if (studentId != null && name != null && email != null) {
            Student instructor = new Student(Integer.parseInt(studentId), name, email);

            // Update instructor details
            boolean updated = studentService.updateStudent(instructor);

            if (updated) {
            	response.sendRedirect("jsp/manage-student.jsp");
            } else {
                response.sendRedirect("/errorPage.jsp");
            }
        }
    }
}
