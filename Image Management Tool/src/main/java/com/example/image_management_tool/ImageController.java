package com.example.image_management_tool;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageController extends BaseController {

    @Override
    public void uploadImage() {
        // display a file selection dialog which allows user to select an image file from their computer.
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload Image");
        fileChooser.getExtensionFilters().addAll(
                // specify the file formats that the user can select
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jpeg", "*.gif")
        );
        // define a File object to represent the file that the user uploaded
        File selectedImage = fileChooser.showOpenDialog(imageView.getScene().getWindow());
        if (selectedImage != null) {
            uploadedImage = selectedImage;
            // use the Image constructor to create an image object from the selected file
            Image image = new Image(selectedImage.toURI().toString());
            imageView.setImage(image);
            // the text of the Label object shows the width and height of the image
            labelText.setText(String.format("Width: %.0f, Height: %.0f", image.getWidth(), image.getHeight()));
        }
    }

    @Override
    public void convertImage() {
        // if there is no image selected, the Label will display a text to inform the user
        // and return without performing the image conversion
        if (imageView.getImage() == null) {
            labelText.setText("No image selected.");
            return;
        }
        try {
            // tries to convert the image
            // creates a new File object for the input file that previously selected and gets the output format from comboBox
            File inputFile = uploadedImage;
            String outputFileExtension = comboBox.getValue();
            // creates a new File object for the converted image file with a new file name and the selected output format
            convertedImage = new File(inputFile.getParent(), inputFile.getName().split("\\.")[0] + "2." + outputFileExtension);
            // calls the convert method
            ImageUtils.convert(inputFile, convertedImage, outputFileExtension);
            System.out.println("Image converted successfully.");
        } catch (IOException e) {
            // if an IOException occurs during the conversion process, an error message will be displayed
            System.out.println("Image conversion failed.");
            e.printStackTrace();
        }
    }

    @Override
    public void saveImage() {
        // if the converted image file does not exist, the Label will display a text to inform the user
        // to perform the image conversion first
        if (convertedImage == null || !convertedImage.exists()) {
            labelText.setText("Please convert the image first.");
            return;
        }
        // sets the extension filter to only show the image files of the format selected in comboBox
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*." + comboBox.getValue())
        );
        // sets the initial file name to be the name of the converted image file
        fileChooser.setInitialFileName(convertedImage.getName());
        File saveFile = fileChooser.showSaveDialog(imageView.getScene().getWindow());

        if (saveFile != null) {
            // renames the converted image file to the selected file
            convertedImage.renameTo(saveFile);
            // displays a text to inform the user that the image was saved successfully
            labelText.setText("Image saved successfully.");
        }
    }
}