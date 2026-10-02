package com.example.javafxapp3;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private Circle createCircle(String strokeColor, String fillColor, double x)
    {
        Circle circle = new Circle();
        circle.setCenterX(x);
        circle.setCenterY(200);
        circle.setRadius(50);
        circle.setStroke(Color.valueOf(strokeColor));
        circle.setStrokeWidth(5);
        circle.setFill(Color.valueOf(fillColor));
        return circle;
    }

    @Override
    public void start(Stage stage) throws IOException {

        Circle circle = createCircle("#ff00ff", "#ff88ff", 100);

        circle.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Circle 1 drag detected");

                Dragboard db = circle.startDragAndDrop(TransferMode.ANY);

                ClipboardContent content = new ClipboardContent();
                content.putString("Circle 2 dropped effect");
                db.setContent(content);
            }
        });

        circle.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mouseEvent.setDragDetect(true);
            }
        });

        Circle circle2 = createCircle("#00ffff", "#88ffff", 300);

        circle2.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                if(dragEvent.getGestureSource()!=circle2
                &&dragEvent.getDragboard().hasString())
                    dragEvent.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                dragEvent.consume();
            }
        });

        circle2.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                Dragboard db = dragEvent.getDragboard();
                if(db.hasString())
                {
                    System.out.println("Dropped: "+db.getString());
                    dragEvent.setDropCompleted(true);
                }
                else
                    dragEvent.setDropCompleted(false);

                dragEvent.consume();
            }
        });

        AnchorPane pane = new AnchorPane();
        pane.getChildren().add(circle);
        pane.getChildren().add(circle2);

        Scene scene = new Scene(pane, 1000, 800);

        stage.setScene(scene);
        stage.setTitle("2D Graphics Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}