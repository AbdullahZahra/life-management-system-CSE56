package com.example.lifemanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;
import java.time.LocalDate;

import java.io.IOException;

public class PersonalInformationController {
    private String firstName;
    private String lastName;
    private String email;
    private String birthdate;
    private String bloodType;

    @FXML
    TextField FirstName;
    @FXML
    TextField LastName;
    @FXML
    TextField Email;
    @FXML
    TextField Birthdate;
    @FXML
    TextField BloodType;

    @FXML
    protected void onGetInfoButtonClick() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        connection = DB.connectDB();

        try {
            String sqlQuery = "select * from personal_information";
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            this.firstName = resultSet.getString("first_name");
            this.lastName = resultSet.getString("last_name");
            this.birthdate = resultSet.getString("birthdate");
            this.email = resultSet.getString("email");
            this.bloodType = resultSet.getString("blood_type");
        } catch (Exception e) {
            System.out.println(e);
        }

        FirstName.setText(firstName);
        LastName.setText(lastName);
        Email.setText(email);
        Birthdate.setText(birthdate);
        BloodType.setText(bloodType);
    }

    private static final String JDBC_URL = "jdbc:mysql://localhost/life_management";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection connection;

    private static void connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found", e);
        }

        connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    private static void updatePersonalInformation(int id, String firstName, String lastName,String email, String birthdate, String bloodType) throws SQLException {
        String updateQuery = "UPDATE personal_information SET first_name=?, last_name=?, email=?, birthdate=?, blood_type=? WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, birthdate);
            preparedStatement.setString(5, bloodType);
            preparedStatement.setInt(6, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Update successful. Rows affected: " + rowsAffected);
            } else {
                System.out.println("Update failed. No rows affected.");
            }
        }
    }



    @FXML
    protected void onUpdateInfoButtonClick() {
        this.firstName = FirstName.getText();
        this.lastName = LastName.getText();
        this.email = Email.getText();
        this.birthdate = Birthdate.getText();
        this.bloodType = BloodType.getText();
        try {
            connect();
            updatePersonalInformation(1, this.firstName , this.lastName,this.email, this.birthdate, this.bloodType);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
