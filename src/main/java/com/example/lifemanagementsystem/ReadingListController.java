package com.example.lifemanagementsystem;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReadingListController implements Initializable {
    @FXML
    public ListView<String> readingList;
    @FXML
    private TextField inputBook;
    private String selectedBook;


    private static final String JDBC_URL = "jdbc:mysql://localhost/life_management";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";


    private static boolean addBook(String bookName) {
        String sql = "INSERT INTO books (name) VALUES (?)";

        try (
                Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatement.setString(1, bookName);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // Retrieve the auto-generated key (id) if needed
                // ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                // if (generatedKeys.next()) {
                //     int generatedId = generatedKeys.getInt(1);
                //     System.out.println("Generated ID: " + generatedId);
                // }

                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private static List<String> getAllBookTitles() {
        List<String> bookTitles = new ArrayList<>();
        String sql = "SELECT name FROM books";

        try (
                Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                String title = resultSet.getString("name");
                bookTitles.add(title);
            }

            return bookTitles;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    String[] books = getAllBookTitles().toArray(new String[0]);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        readingList.getItems().addAll(books);
        readingList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                selectedBook = readingList.getSelectionModel().getSelectedItem();
            }
        });
    }

    @FXML
    private void onAddBookButtonClick() {
        addBook(inputBook.getText());
        readingList.getItems().add(inputBook.getText());
    }

    private static boolean deleteBookByName(String bookName) {
        String sql = "DELETE FROM books WHERE name = ?";

        try (
                Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, bookName);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @FXML
    private void onDeleteBookButtonClicked() {
        System.out.println(deleteBookByName(selectedBook));
        readingList.getItems().remove(selectedBook);
    }

}


