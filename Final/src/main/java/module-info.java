module com.example.imagemanagementtool {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.imagemanagementtool to javafx.fxml;
    exports com.example.imagemanagementtool;
    exports com.example.imagemanagementtool.exception;
    opens com.example.imagemanagementtool.exception to javafx.fxml;
}