package com.example.imagemanagementtool;

import com.example.imagemanagementtool.exception.NoFileSelectedException;
import com.example.imagemanagementtool.exception.UnknownFormatException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.scene.control.ToggleGroup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Controller class for the Image Management Tool application.
 */
public class AppController {
    // create an instance variable to hold a reference to the ScrollPane in fxml
    @FXML
    private ScrollPane scrollPane;

    // create a list of file to hold the selected images for view
    List<File> selectedFiles;

    // method to upload images when the user clicks the "Upload Images" button
    public void uploadImage() {
        try {
            selectedFiles = getSelectedImageFiles();
            if (selectedFiles.isEmpty()) {
                return; // No files selected
            }

            GridPane gallery = createImageGallery(selectedFiles);

            // show gallery in the Scroll Pane
            scrollPane.setContent(gallery);
        } catch (IOException | UnknownFormatException e) {
            handleImageLoadError();
        }
    }

    private List<File> getSelectedImageFiles() {
        // create a new FileChooser object
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose one or more images");

        // add filters to only allow image files with image extensions
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Images Files", "*.png", "*.jpg", "*.gif"));

        // show the file chooser dialog and wait for the user to select one or more files
        return fileChooser.showOpenMultipleDialog(null);
    }

    private GridPane createImageGallery(List<File> selectedFiles) throws IOException, UnknownFormatException {
        GridPane gallery = new GridPane();
        gallery.setHgap(40);
        gallery.setVgap(30);

        int row = 0;
        int col = 0;

        for (File file : selectedFiles) {
            ImageModel image = new ImageModel(file);
            ImageView thumbnail = createThumbnail(file);
            VBox thumbnailContainer = createThumbnailContainer(thumbnail);
            VBox labelContainer = createLabelContainer(image);
            VBox imageCard = createImageCard(thumbnailContainer, labelContainer);

            // add ImageCard to GridPane(gallery)
            gallery.add(imageCard, col, row);

            col++; // move right

            // move down, so there are 5 image cards each row
            if (col == 5) {
                col = 0;
                row++;
            }
        }

        return gallery;
    }

    private ImageView createThumbnail(File file) throws FileNotFoundException {
        ImageView imageView = new ImageView();
        imageView.setImage(new Image(new FileInputStream(file.getPath())));
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);
        return imageView;
    }

    private VBox createThumbnailContainer(ImageView thumbnail) {
        VBox thumbnailContainer = new VBox();
        thumbnailContainer.setPrefSize(100, 100);
        thumbnailContainer.getChildren().add(thumbnail);
        return thumbnailContainer;
    }

    private VBox createLabelContainer(ImageModel image) throws UnknownFormatException {
        Label labelHeight = new Label("Height: " + image.getHeight());
        Label labelWidth = new Label("Width: " + image.getWidth());
        Label labelSize = new Label("File Size: " + image.getFileSizeinMB());
        Label labelType = new Label("Type: " + image.getImageFormat());

        VBox labelContainer = new VBox(labelHeight, labelWidth, labelSize, labelType);
        labelContainer.setSpacing(5);

        return labelContainer;
    }

    private VBox createImageCard(VBox thumbnailContainer, VBox labelContainer) {
        VBox imageCard = new VBox(thumbnailContainer, labelContainer);
        imageCard.setSpacing(10);
        return imageCard;
    }

    private void handleImageLoadError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("An error occurred while adding images.");
        alert.setContentText("Please try again.");
        alert.showAndWait();
    }

    @FXML
    private RadioButton jpg;
    @FXML
    private RadioButton png;
    @FXML
    private RadioButton gif;
    @FXML
    private RadioButton bmp;

    @FXML
    private ToggleGroup format;

    // method to convert images when the user clicks the "Convert & Save" button
    public void convertImage() throws IOException, NoFileSelectedException {

        // check if any file is selected
        if (selectedFiles == null || selectedFiles.isEmpty()) {
            // throw an exception if no file is selected
            throw new NoFileSelectedException("No file selected");
        }

        if (!jpg.isSelected() && !png.isSelected() && !gif.isSelected() && !bmp.isSelected()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select at least one image format.");
            alert.showAndWait();
            return;
        }

        String outputExtension = "";
        // new a converter based on the selected image format checkbox
        if (jpg.isSelected()) {
            outputExtension = "jpg";
        } else if (png.isSelected()) {
            outputExtension = "png";
        } else if (gif.isSelected()) {
            outputExtension = "gif";
        } else if (bmp.isSelected()) {
            outputExtension = "bmp";
        }

        // iterate over the selected files and convert them to the selected format
        if (selectedFiles != null) {
            for (File file : selectedFiles) {
                ImageConverter.getInstance().convert(file, outputExtension);
            }
        }
    }
}
