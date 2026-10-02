module com.example.javafxapp1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxapp1 to javafx.fxml;
    exports com.example.javafxapp1;
}