<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/admin-style.css">
</head>
<body>
    <div class="d-flex" id="wrapper">
        <!-- Sidebar -->
        <jsp:include page="sidebar.jsp" />
        
        <!-- Page Content -->
        <div id="page-content-wrapper" class="content p-4">
            <div class="container-fluid">
                <h2 class="mb-4">Welcome, Admin</h2>
                
                <!-- Dashboard Metrics -->
                <div class="row">
                    <div class="col-md-3">
                        <div class="card text-white bg-primary mb-3">
                            <div class="card-body">
                                <h5 class="card-title">Total Students</h5>
                                <p class="card-text fs-3">1,250</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card text-white bg-success mb-3">
                            <div class="card-body">
                                <h5 class="card-title">Total Instructors</h5>
                                <p class="card-text fs-3">78</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card text-white bg-warning mb-3">
                            <div class="card-body">
                                <h5 class="card-title">Total Courses</h5>
                                <p class="card-text fs-3">56</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card text-white bg-danger mb-3">
                            <div class="card-body">
                                <h5 class="card-title">Pending Approvals</h5>
                                <p class="card-text fs-3">5</p>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Recent Activity -->
                <div class="row">
                    <div class="col-md-8">
                        <div class="card mb-4">
                            <div class="card-header bg-secondary text-white">
                                Recent Activity
                            </div>
                            <div class="card-body">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Activity</th>
                                            <th>Date</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>New Student Registered</td>
                                            <td>March 20, 2025</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>Course Updated: Java Basics</td>
                                            <td>March 18, 2025</td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>Instructor Approved</td>
                                            <td>March 15, 2025</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <!-- Placeholder for Chart -->
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-header bg-info text-white">
                                Student Enrollment Trend
                            </div>
                            <div class="card-body text-center">
                                <p>Graph will be displayed here.</p>
                            </div>
                        </div>
                    </div>
                </div>

            </div> 
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="<%= request.getContextPath() %>/js/admin-script.js"></script>
</body>
</html>
