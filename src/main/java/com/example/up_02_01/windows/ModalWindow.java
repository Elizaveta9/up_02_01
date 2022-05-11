package com.example.up_02_01.windows;

import com.example.up_02_01.StartApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ModalWindow {
    public static void newWindow(String fileName, String title) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource(fileName));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 500, 550);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
