package com.example.lifemanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    protected void onPersonalInformationButtonClick() throws IOException {
//        System.out.println("Window opened");
        Window.openNewWindow("personal-information-view.fxml");
    }
    @FXML
    protected void onReadingListButtonClick() throws IOException {
        Window.openNewWindow("reading-list-view.fxml");
    }
}