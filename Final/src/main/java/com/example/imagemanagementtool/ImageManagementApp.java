package com.example.imagemanagementtool;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ImageManagementApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ImageManagementApp.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,700);
        stage.setTitle("Image Management Tool 2023.12.10");
        stage.setScene(scene);
        stage.setMinHeight(700);
        stage.setMinWidth(900);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}