package com.example.exercise3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    private TextField numField1;
    private TextField numField2;
    private TextField resultField;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Four Function Calculator");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label num1Label = new Label("Number 1:");
        grid.add(num1Label, 0, 0);

        numField1 = new TextField();
        grid.add(numField1, 1, 0);

        Label num2Label = new Label("Number 2:");
        grid.add(num2Label, 0, 1);

        numField2 = new TextField();
        grid.add(numField2, 1, 1);

        Label resultLabel = new Label("Result:");
        grid.add(resultLabel, 0, 2);

        resultField = new TextField();
        resultField.setEditable(false);
        grid.add(resultField, 1, 2);

        Button addButton = new Button("+");
        addButton.setOnAction(e -> add());
        grid.add(addButton, 0, 3);

        Button subButton = new Button("-");
        subButton.setOnAction(e -> subtract());
        grid.add(subButton, 1, 3);

        Button multButton = new Button("*");
        multButton.setOnAction(e -> multiply());
        grid.add(multButton, 2, 3);

        Button divButton = new Button("/");
        divButton.setOnAction(e -> divide());
        grid.add(divButton, 3, 3);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void add() {
        calculateResult(getNumber1(), getNumber2(), '+');
    }

    private void subtract() {
        calculateResult(getNumber1(), getNumber2(), '-');
    }

    private void multiply() {
        calculateResult(getNumber1(), getNumber2(), '*');
    }

    private void divide() {
        calculateResult(getNumber1(), getNumber2(), '/');
    }

    private double getNumber1() {
        return Double.parseDouble(numField1.getText());
    }

    private double getNumber2() {
        return Double.parseDouble(numField2.getText());
    }

    private void calculateResult(double num1, double num2, char operator) {
        double result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    resultField.setText("Error: Division by zero");
                    return;
                }
                break;
        }
        resultField.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        launch(args);
    }
}