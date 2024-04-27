package com.example.image_management_tool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtils {
    public static void convert(File inputFile, File outputFile, String outputFormat) throws IOException {
        // read in the input file to manage the image format
        BufferedImage image = ImageIO.read(inputFile);
        // convert the image data to selected output format.
        ImageIO.write(image, outputFormat, outputFile);
    }
}
