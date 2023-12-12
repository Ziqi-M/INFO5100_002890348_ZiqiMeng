package com.example.imagemanagementtool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javafx.stage.FileChooser;

/**
 * Utility class for converting images to different formats using the Singleton design pattern.
 */
public class ImageConverter {
    // Declare a private static member variable to store the unique instance
    private static ImageConverter instance;

    // Private constructor to prevent external instantiation
    private ImageConverter() {}

    /**
     * Get the unique instance of ImageConverter.
     *
     * @return The ImageConverter instance.
     */
    public static synchronized ImageConverter getInstance() {
        if (instance == null) {
            instance = new ImageConverter();
        }
        return instance;
    }

    /**
     * Converts the input image file to the specified output format.
     *
     * @param file            The input image file to be converted.
     * @param outputExtension The desired output format (e.g., "jpg", "png", "bmp").
     */
    public void convert(File file, String outputExtension) {
        try {
            // Get the name and parts of the input file
            String fileName = file.getName();
            String[] parts = fileName.split("\\.");
            // Convert to lowercase to handle case sensitivity
            String extension = outputExtension.toLowerCase();
            // Create a new filename with the specified output extension
            String newFileName = parts[0] + "." + extension;

            // Read the input image file into a BufferedImage object
            BufferedImage image = ImageIO.read(file);

            // Create a new BufferedImage to handle transparent channels
            BufferedImage newImage = new BufferedImage(
                    image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

            if (extension.equals("jpg") || extension.equals("jpeg")) {
                // If it is JPG, create a Graphics2D with a white background and draw the original image
                Graphics2D g2d = newImage.createGraphics();
                g2d.setColor(Color.WHITE);
                g2d.fillRect(0, 0, newImage.getWidth(), newImage.getHeight());
                g2d.drawImage(image, 0, 0, null);
                g2d.dispose();
            } else if (extension.equals("bmp")) {
                // If it is BMP, create a Graphics2D and draw the original image
                Graphics2D g2d = newImage.createGraphics();
                g2d.drawImage(image, 0, 0, null);
                g2d.dispose();
            } else {
                // For other formats, copy the image directly
                Graphics g = newImage.getGraphics();
                g.drawImage(image, 0, 0, null);
                g.dispose();
            }

            // Show a file chooser dialog to select the output directory and name the output file
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose the output directory");
            fileChooser.setInitialFileName(newFileName);
            File location = fileChooser.showSaveDialog(null);

            // Write the output file in the specified format to the selected location
            ImageIO.write(newImage, extension, location);
        } catch (IOException e) {
            // Handle the exception by printing the stack trace
            e.printStackTrace();
        }
    }
}
