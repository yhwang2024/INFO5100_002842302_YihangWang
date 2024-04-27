package com.example.image_management_tool;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ComboBox;
import javafx.fxml.FXML;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public abstract class BaseController implements ImageOperation {

    @FXML protected ImageView imageView;
    @FXML protected Label labelText;
    @FXML protected ComboBox<String> comboBox;

    protected File uploadedImage;
    protected File convertedImage;

    @FXML public void initialize() {
        setupComboBox();
    }

    protected void setupComboBox() {
        // add four different String values of image formats to the comBox
        comboBox.getItems().addAll("jpg", "png", "jpeg", "gif");
        // set the default selection of the comboBox to the first item in the list
        comboBox.getSelectionModel().selectFirst();
    }
    // implements some methods from ImageOperation and declares abstract methods to be implemented by ImageController
    @Override
    public abstract void uploadImage();

    @Override
    public abstract void convertImage();

    @Override
    public abstract void saveImage();
}
