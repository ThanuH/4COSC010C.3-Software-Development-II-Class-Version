package com.example.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Passengers extends Application {
    private String fName;
    private String lName;
    private String licNo;
    private int fuelVolume;

    public String getFName() {return fName;}

    public void setFName(String fName) {this.fName = fName;}

    public String getLName() {return lName;}

    public void setLName(String lName) {this.lName = lName;}

    public String getLicNo() {return licNo;}

    public void setLicNo(String licNo) {this.licNo = licNo;}

    public int getFuelVolume() {return fuelVolume;}

    public void setFuelVolume(int fuelVolume) {this.fuelVolume = fuelVolume;}


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Main APP");
        stage.setScene(scene);
        stage.show();
    }
}