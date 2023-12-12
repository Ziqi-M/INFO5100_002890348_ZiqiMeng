package com.example.imagemanagementtool.exception;

import javafx.scene.control.Alert;

/**
 * Exception thrown when an unknown image format is encountered.
 */
public class UnknownFormatException extends Exception {

    /**
     * Constructs an UnknownFormatException with the specified detail message.
     *
     * @param message The detail message.
     */
    public UnknownFormatException(String message) {
        super(message);

        // Display an error alert to inform the user about the issue
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Please select images with suitable format.");
        alert.showAndWait();
    }
}
