package com.example.javafxapp1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    TextField tfNume;
    TextField tfVarsta;
    ComboBox cbSex;
    ChoiceBox choiceProgram;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("macheta.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 500);

        initializareScena(scene);

        stage.setTitle("Adaugare studenti");
        stage.setScene(scene);
        stage.show();
    }

    private void initializareScena(Scene scenaAdaugare)
    {
        tfNume = (TextField) scenaAdaugare.lookup("#tfNume");
        tfVarsta = (TextField) scenaAdaugare.lookup("#tfVarsta");
        cbSex = (ComboBox) scenaAdaugare.lookup("#cbSex");
        ObservableList<String> optiuni =
                FXCollections.observableArrayList("Masculin", "Feminin");
        cbSex.setItems(optiuni);
        choiceProgram = (ChoiceBox) scenaAdaugare.lookup("#choiceProgram");
        choiceProgram.getItems().add("Licenta");
        choiceProgram.getItems().add("Masterat");
        choiceProgram.getItems().add("Doctorat");

        Button btnAdauga = (Button) scenaAdaugare.lookup("#btnAdauga");
        btnAdauga.setOnMousePressed(adaugaStudent(scenaAdaugare));
        /*btnAdauga.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (tfNume.getText().isEmpty()) {
                    tfNume.requestFocus();
                    tfNume.setPromptText("Introduceti numele!");
                } else if (tfVarsta.getText() == null || !tfVarsta.getText().matches("[0-9]+"))
                {
                    tfVarsta.requestFocus();
                    tfVarsta.setPromptText("Varsta incorecta!");
                }
                else
                {
                    try
                    {
                        String nume = tfNume.getText();
                        int varsta = Integer.parseInt(tfVarsta.getText());
                        String sex = cbSex.getValue().toString();
                        String programStudiu = choiceProgram.getValue().toString();

                        Student student = new Student(nume, varsta, sex, programStudiu);
                        System.out.println(student.toString());

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText(student.toString());
                        alert.show();
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        });
*/
    }

    private EventHandler<MouseEvent> adaugaStudent(Scene scene)
    {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (tfNume.getText().isEmpty()) {
                    tfNume.requestFocus();
                    tfNume.setPromptText("Introduceti numele!");
                } else if (tfVarsta.getText() == null || !tfVarsta.getText().matches("[0-9]+"))
                {
                    tfVarsta.requestFocus();
                    tfVarsta.setPromptText("Varsta incorecta!");
                }
                else
                {
                    try
                    {
                        String nume = tfNume.getText();
                        int varsta = Integer.parseInt(tfVarsta.getText());
                        String sex = cbSex.getValue().toString();
                        String programStudiu = choiceProgram.getValue().toString();

                        Student student = new Student(nume, varsta, sex, programStudiu);
                        System.out.println(student.toString());

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText(student.toString());
                        alert.show();
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        };
    }

    public static void main(String[] args) {
        launch();
    }
}