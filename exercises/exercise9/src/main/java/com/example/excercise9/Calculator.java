package com.example.excercise9;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.util.Stack;
public class Calculator extends Application {

    private TextField display;

    private String input = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        display = new TextField();
        display.setEditable(false);
        display.setMinWidth(Region.USE_PREF_SIZE);
        grid.add(display, 0, 0, 4, 1);

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+", "C"
        };

        for (int i = 0; i < buttonLabels.length; i++) {
            final String label = buttonLabels[i];
            Button button = new Button(label);
            button.setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
            button.setOnAction(e -> buttonClick(label));
            GridPane.setConstraints(button, i % 4, i / 4 + 1);
            grid.getChildren().add(button);
        }

        for (int i = 0; i < 4; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setHgrow(Priority.ALWAYS);
            grid.getColumnConstraints().add(column);
        }

        Scene scene = new Scene(grid, 240, 320);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void buttonClick(String label) {
        if (label.matches("[0-9.]")) {
            input += label;
        } else if (label.equals("+") || label.equals("-") || label.equals("*") || label.equals("/")) {
            input += " " + label + " ";
        } else if (label.equals("C")) {
            input = "";
        } else if (label.equals("=")) {
            try {
                input += " = " + calculate(input);
            } catch (MyException e1) {
                showAlert(e1.getMessage());
                input = "";
                return;
            }
            display.setText(input);
            input = "";
            return;
        }

        display.setText(input);
    }

    private String calculate(String input) throws MyException {
        String[] comput = input.split(" ");
        Stack<Double> stack = new Stack<>();
        Double m = Double.parseDouble(comput[0]);
        stack.push(m);

        for (int i = 1; i < comput.length; i++) {
            if (i % 2 == 1) {
                if (comput[i].equals("+")) {
                    stack.push(Double.parseDouble(comput[i + 1]));
                }
                if (comput[i].equals("-")) {
                    stack.push(-Double.parseDouble(comput[i + 1]));
                }
                if (comput[i].equals("*")) {
                    Double d = stack.peek();
                    stack.pop();
                    stack.push(d * Double.parseDouble(comput[i + 1]));
                }
                if (comput[i].equals("/")) {
                    double help = Double.parseDouble(comput[i + 1]);
                    if (help == 0) {
                        throw new MyException("Cannot divide by zero.");
                    }
                    double d = stack.peek();
                    stack.pop();
                    stack.push(d / help);
                }
            }
        }

        double d = 0d;

        while (!stack.isEmpty()) {
            d += stack.peek();
            stack.pop();
        }

        return String.valueOf(d);
    }

    private void showAlert(String message) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        });
    }
}

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
