document.addEventListener("DOMContentLoaded", function () {
    // Fetch the instructors dynamically when the page loads
    fetchStudents();

    // Handle success/error messages
    setTimeout(function () {
        let successMsg = document.getElementById("successMessage");
        let errorMsg = document.getElementById("errorMessage");

        if (successMsg) successMsg.remove();
        if (errorMsg) errorMsg.remove();
    }, 3000);
});

function fetchStudents() {
    fetch('/onlinemanagement/ManageStudents')
        .then(response => response.json())
        .then(data => {
            console.log("Fetched Data:", data);
            let tableBody = document.querySelector("#instructorTableBody");
            tableBody.innerHTML = ""; // Clear existing table data

            // Populate the table with students
            data.forEach((student, index) => {
                tableBody.innerHTML += `<tr>
                    <td>${index + 1}</td>
                    <td>${student.name}</td>
                    <td>${student.email}</td>
                    <td>
                        <button class="btn btn-warning btn-sm edit-btn"
                            data-id="${student.id}" 
                            data-name="${student.name}" 
                            data-email="${student.email}">
                            Edit
                        </button>
                        <button class="btn btn-danger btn-sm delete-btn" 
                            data-id="${student.id}">
                            Delete
                        </button>
                    </td>
                </tr>`;
            });

            // Bind the event listener to the Edit buttons after the table is populated
            bindEditButtons();

            // Bind the event listener to the Delete buttons
            bindDeleteButtons();
        })
        .catch(error => console.error("Error fetching instructors:", error));
}

// Function to bind event listeners to dynamically generated edit buttons
function bindEditButtons() {
    const editButtons = document.querySelectorAll(".edit-btn");

    // Add click event listener for each edit button
    editButtons.forEach(button => {
        button.addEventListener("click", function () {
            // Get the data attributes from the clicked button
            const id = this.dataset.id;
            const name = this.dataset.name;
            const email = this.dataset.email;

            // Populate the modal fields with the data
            document.getElementById("edit-id").value = id;
            document.getElementById("edit-name").value = name;
            document.getElementById("edit-email").value = email;

            // Show the modal
            new bootstrap.Modal(document.getElementById("editInstructorModal")).show();
        });
    });
}

// Function to bind event listeners to dynamically generated delete buttons
function bindDeleteButtons() {
    const deleteButtons = document.querySelectorAll(".delete-btn");

    // Add click event listener for each delete button
    deleteButtons.forEach(button => {
        button.addEventListener("click", function () {
            const id = this.dataset.id;
            showDeleteConfirmation(id); // Call the confirmation modal
        });
    });
}

let studentIdToDelete = null;

function showDeleteConfirmation(id) {
    // Store the instructor id to delete
    studentIdToDelete = id;

    // Show the delete confirmation modal
    new bootstrap.Modal(document.getElementById('deleteConfirmationModal')).show();
}

function deleteStudent() {
    if (studentIdToDelete !== null) {
        // Perform the deletion (e.g., via AJAX or form submission)
        // Redirect to delete instructor servlet with instructorIdToDelete
        window.location.href = `/onlinemanagement/DeleteStudentServlet?id=${studentIdToDelete}`;
    }
    // Hide the modal after confirming deletion
    new bootstrap.Modal(document.getElementById('deleteConfirmationModal')).hide();
}
