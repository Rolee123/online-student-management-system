<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/sidebar.css">
<script src="<%= request.getContextPath() %>/js/sidebar.js" defer></script>

<aside id="sidebar">
    <div class="sidebar-header">
        <h3>Admin Panel</h3>
    </div>
    <ul class="components">
        <li><a href="dashboard.jsp">Dashboard</a></li>
		<li><a href="<%= request.getContextPath() %>/jsp/manage-instructor.jsp">Manage Instructors</a></li>
        <li><a href="<%= request.getContextPath() %>/jsp/manage-student.jsp">Manage Students</a></li>
        <li><a href="manage-courses.jsp">Manage Courses</a></li>
        <li><a href="logout.jsp" class="logout-btn">Logout</a></li>
    </ul>
</aside>
