package com.studentmanagement.servlet;

import com.studentmanagement.service.UserService;
import com.studentmanagement.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4312410229560916018L;
	
	private UserService userService;

    @Override
    public void init() throws ServletException {
        // Initialize UserService (Service Layer)
        this.userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            User user = userService.authenticateUser(username, password);

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                // Redirect based on role
                switch (user.getRole().toLowerCase()) {
                    case "admin":
                        response.sendRedirect("jsp/admin-dashboard.jsp");
                        break;
                    case "instructor":
                        response.sendRedirect("jsp/instructorDashboard.jsp");
                        break;
                    case "student":
                        response.sendRedirect("jsp/studentDashboard.jsp");
                        break;
                    default:
                        response.sendRedirect("login.jsp?error=Invalid role");
                        break;
                }
            } else {
                response.sendRedirect("login.jsp?error=Invalid credentials");
            }
        } catch (Exception e) {
//            ExceptionHandler.handleException(e, response);
        }
    }
}
