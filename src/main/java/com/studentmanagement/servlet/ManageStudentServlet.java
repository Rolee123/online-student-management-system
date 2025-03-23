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
import com.studentmanagement.model.Student;
import com.studentmanagement.service.StudentService;

@WebServlet("/ManageStudents")
public class ManageStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1625807019885821063L;
    private static final Logger LOGGER = Logger.getLogger(ManageStudentServlet.class.getName());
    private final StudentService studentService = new StudentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name").trim();
        String email = request.getParameter("email").trim();

        if (name.isEmpty() || email.isEmpty()) {
            request.getSession().setAttribute("errorMessage", "All fields are required!");
        } else {
            boolean success = studentService.addStudent(name, email);
            if (success) {
                request.getSession().setAttribute("successMessage", "Student added successfully!");
            } else {
                request.getSession().setAttribute("errorMessage", "Student with this email already exists!");
            }
        }
        response.sendRedirect("jsp/manage-student.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> instructors = studentService.getAllStudents();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String json = gson.toJson(instructors);
        out.print(json);
        out.flush();
    }


}
