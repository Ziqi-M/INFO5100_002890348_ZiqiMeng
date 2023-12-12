package com.example.imagemanagementtool;

import com.example.imagemanagementtool.exception.UnknownFormatException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Represents a model for an image, providing information about the image properties.
 */
public class ImageModel implements ImageInfo {
    private String imageName;
    private String width;
    private String height;
    private long fileSize;

    /**
     * Constructs an ImageModel object based on the provided image file.
     *
     * @param file The image file from which to extract properties.
     * @throws IOException If an error occurs while reading the image file.
     */
    public ImageModel(File file) throws IOException {
        try {
            // read the image file using the ImageIO
            BufferedImage image = ImageIO.read(file);

            // set the member variables based on the image properties
            imageName = file.getName();
            fileSize = file.length();
            width = String.valueOf(image.getWidth());
            height = String.valueOf(image.getHeight());

        } catch (IOException e) {
            // handle the exception
            e.printStackTrace();
        }
    }

    /**
     * Gets the name of the image file.
     *
     * @return The image file name.
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * Gets the width of the image.
     *
     * @return The image width.
     */
    public String getWidth() {
        return width;
    }

    /**
     * Gets the height of the image.
     *
     * @return The image height.
     */
    public String getHeight() {
        return height;
    }

    /**
     * Calculates and returns the size of the image file in MB.
     *
     * @return The formatted size of the image file.
     */
    public String getFileSizeinMB() {
        double fileSizeMB = (double)fileSize / (1024 * 1024);
        return String.format("%.2fMB", fileSizeMB);
    }

    /**
     * Determines and returns the image format based on the file extension.
     *
     * @return The image format (e.g., "jpg", "png", "gif", "bmp").
     * @throws UnknownFormatException If the image format is unknown or unsupported.
     */
    public String getImageFormat() throws UnknownFormatException {
        String format = imageName.substring(imageName.lastIndexOf(".") + 1);
        format = format.toLowerCase();
        if(format.equals("jpg") || format.equals("png") || format.equals("gif") || format.equals("bmp") ){
            return format;
        } else {
            throw new UnknownFormatException("Unknown Image Format");
        }
    }
}
