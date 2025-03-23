package com.studentmanagement.service;

import com.studentmanagement.dao.UserDAO;
import com.studentmanagement.model.User;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    public User authenticateUser(String username, String password) throws Exception {
        return userDAO.getUserByEmail(username);
    }
}
