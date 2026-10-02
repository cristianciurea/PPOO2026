module com.example.javafxapp3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxapp3 to javafx.fxml;
    exports com.example.javafxapp3;
}