package com.studentmanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtil {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=StudentManagementDB;encrypt=true;trustServerCertificate=true";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";
    private static final Logger LOGGER = Logger.getLogger(DBUtil.class.getName());

    static {
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // Explicitly load the driver
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Database driver not found", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
