package com.studentmanagement.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.studentmanagement.model.Instructor;
import com.studentmanagement.service.InstructorService;

@WebServlet("/ManageInstructors")
public class ManageInstructorServlet extends HttpServlet {
    private static final long serialVersionUID = 1625807019885821063L;
    private static final Logger LOGGER = Logger.getLogger(ManageInstructorServlet.class.getName());
    private final InstructorService instructorService = new InstructorService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name").trim();
        String email = request.getParameter("email").trim();

        if (name.isEmpty() || email.isEmpty()) {
            request.getSession().setAttribute("errorMessage", "All fields are required!");
        } else {
            boolean success = instructorService.addInstructor(name, email);
            if (success) {
                request.getSession().setAttribute("successMessage", "Instructor added successfully!");
            } else {
                request.getSession().setAttribute("errorMessage", "Instructor with this email already exists!");
            }
        }
        response.sendRedirect("jsp/manage-instructor.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Instructor> instructors = instructorService.getAllInstructors();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String json = gson.toJson(instructors);
        out.print(json);
        out.flush();
    }


}