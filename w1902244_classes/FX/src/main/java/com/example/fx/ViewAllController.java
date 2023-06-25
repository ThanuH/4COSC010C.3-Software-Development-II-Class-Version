package com.example.fx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class ViewAllController {

    @FXML
    private TableView<Passengers> queue1;

    @FXML
    private TableView<Passengers> queue2;

    @FXML
    private TableView<Passengers> queue3;

    @FXML
    private TableView<Passengers> queue4;

    @FXML
    private TableView<Passengers> queue5;

    @FXML
    private  TableView<Passengers> waitingQueue;

    @FXML
    protected void searchByQueue(){
        for (int i = 0; i < 5; i++) {
            ObservableList<Passengers> PassengerDetails = FXCollections.observableArrayList();
            for (int j = 0; j < 6; j++) {
                if(FuelQueue.MainQueue[i][j] != null){
                    PassengerDetails.add(FuelQueue.MainQueue[i][j]);
                }
            }
            if(i == 0){ queue1.setItems(PassengerDetails);}
            if(i == 1){ queue2.setItems(PassengerDetails);}
            if(i == 2){ queue3.setItems(PassengerDetails);}
            if(i == 3){ queue4.setItems(PassengerDetails);}
            if(i == 4){ queue5.setItems(PassengerDetails);}

        }
        ObservableList<Passengers> waitingData = FXCollections.observableArrayList();
        for (int j = 0; j <6 ; j++) {
            if(WaitingQueue.waitingQueue!=null){
                waitingData.add((WaitingQueue.waitingQueue[j]));
            }
        }
        waitingQueue.setItems(waitingData);
    }
}
