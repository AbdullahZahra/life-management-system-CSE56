package com.example.lifemanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onPersonalInformationButtonClick() throws IOException {
        System.out.println("Window opened");
        Window.openNewWindow("personal-information-view.fxml");
    }
}