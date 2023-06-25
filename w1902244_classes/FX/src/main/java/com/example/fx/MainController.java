package com.example.fx;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    protected void viewDetails() throws IOException {
        Stage newStage=new Stage();
        newStage.setTitle("View-all");
        Parent root= FXMLLoader.load(getClass().getResource("view-all.fxml"));
        newStage.setScene(new Scene(root));
        newStage.show();

    }

    @FXML
    protected void searchPassenger() throws IOException {
        Stage newStage=new Stage();
        newStage.setTitle("Search-by-passenger");
        Parent root= FXMLLoader.load(getClass().getResource("search-by.fxml"));
        newStage.setScene(new Scene(root));
        newStage.show();

    }

    @FXML
    protected void quit(){
        Platform.exit();

    }
}
