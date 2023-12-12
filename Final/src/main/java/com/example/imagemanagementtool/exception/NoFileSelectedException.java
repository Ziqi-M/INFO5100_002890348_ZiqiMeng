package com.example.imagemanagementtool.exception;

import javafx.scene.control.Alert;

/**
 * Exception thrown when no image file is selected.
 */
public class NoFileSelectedException extends Exception {

    /**
     * Constructs a NoFileSelectedException with the specified detail message.
     *
     * @param message The detail message.
     */
    public NoFileSelectedException(String message) {
        super(message);

        // Display an error alert to inform the user about the issue
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Please select at least one image.");
        alert.showAndWait();
    }
}
