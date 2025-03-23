package com.studentmanagement.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentmanagement.service.InstructorService;

@WebServlet("/DeleteInstructorServlet")
public class DeleteInstructorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private InstructorService instructorService;

    @Override
    public void init() throws ServletException {
        instructorService = new InstructorService(); // Initialize service layer
    }

 // Handle GET request for deleting instructor
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String instructorId = request.getParameter("id");

        if (instructorId != null) {
            boolean deleted = instructorService.deleteInstructor(Integer.parseInt(instructorId));

            if (deleted) {
                response.sendRedirect("jsp/manage-instructor.jsp?deleteSuccess=true");  // Redirect after successful deletion
            } else {
                response.sendRedirect("jsp/manage-instructor.jsp?deleteFailed=true");  // Redirect in case of failure
            }
        } else {
            response.sendRedirect("jsp/manage-instructor.jsp?deleteFailed=true");  // Handle missing ID case
        }
    }
}
