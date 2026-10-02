module com.example.javafxapp2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxapp2 to javafx.fxml;
    exports com.example.javafxapp2;
}