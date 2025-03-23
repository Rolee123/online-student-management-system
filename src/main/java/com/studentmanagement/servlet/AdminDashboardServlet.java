package com.studentmanagement.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin-dashboard")
public class AdminDashboardServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2949904060488738391L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin-dashboard.jsp");
        dispatcher.forward(request, response);
    }
}
