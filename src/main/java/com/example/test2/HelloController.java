package com.example.test2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML TextField textField;
    @FXML
    Label output;
    public void solveOnClick(ActionEvent actionEvent) {;
        String cc = textField.getText();
        try{
            int value = Integer.parseInt(cc);
            if(checkForSqrt(value)){
                output.setText("Число " + value + " является полным квадратом.");
            }
            else{
                output.setText("Число " + value + " не является полным квадратом.");
            }
        }
        catch (Exception ex){
            output.setText("Введены некорректные данные.");
        }
    }
    public static boolean checkForSqrt(int x){
        return x % Math.sqrt(x) == 0;
    }
}