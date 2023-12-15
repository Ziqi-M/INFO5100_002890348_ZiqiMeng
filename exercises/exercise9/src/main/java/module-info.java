module com.example.excercise9 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.excercise9 to javafx.fxml;
    exports com.example.excercise9;
}