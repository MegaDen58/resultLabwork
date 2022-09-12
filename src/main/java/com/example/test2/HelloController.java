package com.example.test2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.lang.reflect.Field;

public class HelloController extends ActionEvent {

    @FXML
    Label outputText;
    @FXML
    TextField input;
    @FXML
    Label errorOutput;


    public void solveOnClick(ActionEvent actionEvent) throws IOException {
        try {
            String cc = input.getText();
            int value = Integer.parseInt(cc);
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            Pane root = fxmlLoader.load(getClass().getResource("secondscene.fxml").openStream());
            Scene scene = new Scene(root, 600, 350);
            stage.setScene(scene);
            stage.setTitle("Полный квадрат");
            stage.getIcons().add(new Image("file:icon.png"));
            errorOutput.setText("");
            Label label = (Label) scene.lookup("#outputText");

            if(checkForSqrt(value)){
                label.setText("Число " + value + " является полным квадратом.");
            }
            else if (!checkForSqrt(value)){
                label.setText("Число " + value + " не является полным квадратом.");
            }
            stage.showAndWait();
        } catch (Exception ex) {
            errorOutput.setText("Ошибка ввода данных.");
        }
    }



    public static boolean checkForSqrt(int x){
        return x % Math.sqrt(x) == 0;
    }
}