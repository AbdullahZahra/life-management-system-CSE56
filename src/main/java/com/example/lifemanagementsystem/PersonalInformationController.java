package com.example.lifemanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PersonalInformationController {
    @FXML
    protected void onUpdateInfoButtonClick() {
        DB.connectDB();
    }
}
