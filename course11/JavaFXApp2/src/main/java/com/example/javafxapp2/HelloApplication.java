package com.example.javafxapp2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Text lbName = new Text("Nume si prenume");
        TextField tfName = new TextField();

        Text lbGender = new Text("Sex");
        ToggleGroup groupGen = new ToggleGroup();
        RadioButton btnMasculin = new RadioButton("Masculin");
        btnMasculin.setToggleGroup(groupGen);
        RadioButton btnFeminin = new RadioButton("Feminin");
        btnFeminin.setToggleGroup(groupGen);

        Text lbTaxaPlatita = new Text("Taxa platita");
        ToggleButton yes = new ToggleButton("DA");
        ToggleButton no = new ToggleButton("NU");
        ToggleGroup groupTaxPaid = new ToggleGroup();
        yes.setToggleGroup(groupTaxPaid);
        no.setToggleGroup(groupTaxPaid);

        Text lbSections = new Text("Sectiuni alocate");
        CheckBox checkBoxAI = new CheckBox("Artificial Intelligence");
        checkBoxAI.setIndeterminate(false);

        CheckBox checkBoxMobile = new CheckBox("Mobile Technologies");
        checkBoxMobile.setIndeterminate(false);

        Text lbEducation = new Text("Studii absolvite");
        ObservableList<String> listaPrograme = FXCollections.observableArrayList("Licenta",
                "Masterat", "Doctorat");
        ListView<String> educationListView = new ListView<>(listaPrograme);

        Text lbLocation = new Text("Locatie eveniment");
        ChoiceBox locationChoiceBox = new ChoiceBox();
        locationChoiceBox.getItems().addAll("Bucuresti", "Cluj", "Timisoara");

        Button btnRegister = new Button("Register");
        btnRegister.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    String name = tfName.getText();
                    String sex = null;
                    if (btnMasculin.isSelected())
                        sex = btnMasculin.getText();
                    else if (btnFeminin.isSelected())
                        sex = btnFeminin.getText();
                    boolean taxPaid;
                    if (yes.isSelected())
                        taxPaid = true;
                    else
                        taxPaid = false;
                    String[] sectionsAllocated = new String[2];
                    if (checkBoxAI.isSelected())
                        sectionsAllocated[0] = checkBoxAI.getText();
                    if (checkBoxMobile.isSelected())
                        sectionsAllocated[1] = checkBoxMobile.getText();
                    String studies = educationListView.getSelectionModel().
                            getSelectedItem().toString();
                    String location = locationChoiceBox.getSelectionModel().
                            getSelectedItem().toString();

                    Registration registration = new Registration(name, sex, taxPaid,
                            sectionsAllocated, studies, location);
                    System.out.println(registration);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Informare");
                    alert.setContentText(registration.toString());
                    alert.show();
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(500, 500);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(lbName, 0, 0);
        gridPane.add(tfName, 1, 0);

        gridPane.add(lbGender, 0, 2);
        gridPane.add(btnMasculin, 1, 2);
        gridPane.add(btnFeminin, 2, 2);

        gridPane.add(lbTaxaPlatita, 0, 3);
        gridPane.add(yes, 1, 3);
        gridPane.add(no, 2, 3);

        gridPane.add(lbSections, 0, 4);
        gridPane.add(checkBoxAI, 1, 4);
        gridPane.add(checkBoxMobile, 2, 4);

        gridPane.add(lbEducation, 0, 5);
        gridPane.add(educationListView, 1, 5);

        gridPane.add(lbLocation, 0, 6);
        gridPane.add(locationChoiceBox, 1, 6);

        gridPane.add(btnRegister, 2, 8);

        Scene scene = new Scene(gridPane);

        stage.setTitle("Registration Form");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}
