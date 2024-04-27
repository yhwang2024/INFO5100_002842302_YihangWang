package com.example.image_management_tool;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ImageApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // initial the GUI for image management tool
        FXMLLoader fxmlLoader = new FXMLLoader(ImageApplication.class.getResource("hello-view.fxml"));
        // create a new stage for the GUI and sets the scene to the loaded view
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setTitle("Image Management Tool");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}