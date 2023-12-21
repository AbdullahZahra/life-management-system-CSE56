package com.example.lifemanagementsystem;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Window {
    public static void openNewWindow(String resource) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(resource));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Your Life Management System");
        stage.setScene(scene);
        stage.show();
    }
}
