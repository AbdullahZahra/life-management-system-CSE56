module com.example.lifemanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.lifemanagementsystem to javafx.fxml;
    exports com.example.lifemanagementsystem;
}