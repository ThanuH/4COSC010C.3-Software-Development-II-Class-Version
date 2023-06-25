package com.example.fx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SearchByController {
    @FXML
    private TextField search;
    @FXML
    private Label LBLfname;
    @FXML
    private Label LBLlname;
    @FXML
    private Label LBLlis;
    @FXML
    private Label LBLfuelv;
    @FXML
    private Label LBLqno;

    @FXML
    protected  void passengerSearch(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if(FuelQueue.MainQueue[i][j] != null){
                    if(FuelQueue.MainQueue[i][j].getLicNo().equalsIgnoreCase(search.getText()));
                    LBLfname.setText(FuelQueue.MainQueue[i][j].getFName());
                    LBLlname.setText(FuelQueue.MainQueue[i][j].getLName());
                    LBLlis.setText(FuelQueue.MainQueue[i][j].getLicNo());
                    LBLfuelv.setText(String.valueOf(FuelQueue.MainQueue[i][j].getFuelVolume()));
                    LBLqno.setText(String.valueOf(i+1));

                }

            }

        }
    }


}
