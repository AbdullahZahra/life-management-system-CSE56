package com.example.lifemanagementsystem;

import java.sql.*;

public class DB {
    public static Connection connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting...");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/life_management", "root", "");
            System.out.println("Database connected");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
