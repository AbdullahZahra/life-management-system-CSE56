module com.example.lifemanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lifemanagementsystem to javafx.fxml;
    exports com.example.lifemanagementsystem;
}