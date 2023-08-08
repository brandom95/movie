package com.example.movfinal;
import java.lang.Exception;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class OpenMovieDBApp extends Application {

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("OPEN MOVIE DB");

        // Load the custom icon image from the resources/icons directory
        Image iconImage = new Image(getClass().getResourceAsStream("/icons/icon.png"));

        primaryStage.getIcons().add(iconImage);

        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/com/example/movfinal/styles.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
