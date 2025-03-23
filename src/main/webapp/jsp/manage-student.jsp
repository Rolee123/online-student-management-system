<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Instructors</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/manage-student.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/admin-style.css">
</head>
<body>

    <div class="wrapper">
        <!-- Sidebar -->
        <jsp:include page="sidebar.jsp" />

        <!-- Page Content -->
        <div class="content">
            <div class="container mt-4">
                <%-- <!-- Success/Error Messages -->
                <c:if test="${not empty sessionScope.successMessage}">
                    <div class="alert alert-success" id="successMessage">${sessionScope.successMessage}</div>
                    <c:remove var="successMessage" scope="session"/>
                </c:if>

                <c:if test="${not empty sessionScope.errorMessage}">
                    <div class="alert alert-danger" id="errorMessage">${sessionScope.errorMessage}</div>
                    <c:remove var="errorMessage" scope="session"/>
                </c:if> --%>

                <h2>Manage Student</h2>

                <!-- Add Instructor Form -->
                <div class="card p-3 mb-4">
                    <h5>Add New Student</h5>
                    <form action="<%= request.getContextPath() %>/ManageStudents" method="post">
                        <div class="row">
                            <div class="col-md-5">
                                <input type="text" name="name" class="form-control" placeholder="Full Name" required>
                            </div>
                            <div class="col-md-5">
                                <input type="email" name="email" class="form-control" placeholder="Email" required>
                            </div>
                            <div class="col-md-2">
                                <button type="submit" class="btn btn-primary">Add</button>
                            </div>
                        </div>
                    </form>
                </div>

                <!-- Instructor List -->
                <div class="card p-3">
                    <h5>Student List</h5>
                    <table class="table table-bordered mt-3">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody id="instructorTableBody">
                            <!-- Instructors will be loaded dynamically here -->
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <!-- Edit Instructor Modal -->
    <div class="modal fade" id="editInstructorModal" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="<%= request.getContextPath() %>/EditStudentServlet" method="post">
                    <div class="modal-header">
                        <h5 class="modal-title" id="editModalLabel">Edit Student</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" name="id" id="edit-id">
                        <div class="mb-3">
                            <label>Name</label>
                            <input type="text" name="name" id="edit-name" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label>Email</label>
                            <input type="email" name="email" id="edit-email" class="form-control" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">Save Changes</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    
    <!-- Delete Confirmation Modal -->
    <div class="modal fade" id="deleteConfirmationModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
            	<form action="<%= request.getContextPath() %>/DeleteStudentServlet" method="post">
	                <div class="modal-header">
	                    <h5 class="modal-title" id="deleteModalLabel">Confirm Deletion</h5>
	                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	                </div>
	                <div class="modal-body">
	                    Are you sure you want to delete this student?
	                </div>
	                <div class="modal-footer">
	                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
	                    <button type="button" class="btn btn-danger" id="confirmDeleteBtn" onclick="deleteStudent()">Delete</button>
	                </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="<%= request.getContextPath() %>/js/manage-student.js"></script>

</body>
</html>
