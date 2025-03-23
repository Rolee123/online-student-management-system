package com.studentmanagement.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentmanagement.model.Instructor;
import com.studentmanagement.service.InstructorService;

@WebServlet("/EditInstructorServlet")
public class EditInstructorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private InstructorService instructorService;

    @Override
    public void init() throws ServletException {
        instructorService = new InstructorService(); // Initialize service layer
    }

    // Method to handle POST requests for updating instructor details
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String instructorId = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        if (instructorId != null && name != null && email != null) {
            Instructor instructor = new Instructor(Integer.parseInt(instructorId), name, email);

            // Update instructor details
            boolean updated = instructorService.updateInstructor(instructor);

            if (updated) {
            	response.sendRedirect("jsp/manage-instructor.jsp");
            } else {
                response.sendRedirect("/errorPage.jsp");
            }
        }
    }
}
