package com.example.fx;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class FuelQueue extends Passengers {

    static FuelQueue[][] MainQueue = new FuelQueue[5][6];
    static int fuelVolume = 6600;


    static int revenueArray [] = new int [5];


    static Scanner sc = new Scanner(System.in);

    //----------------------------------------------------------------------------------------------------------------------
    static void viewAllQueues(){
        for (int i = 0,index = 1; i < 5; i++, index ++) {
            System.out.println("Queue" + index);
            for (int j = 0; j < 6; j++) {
                if(MainQueue[i][j] == null){
                    System.out.print("Empty  ");
                }else {System.out.print(MainQueue[i][j].getFName() + "  ");}
            }
            System.out.println();
            System.out.println();
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    static void viewEmptyQueue(){
        for (int i = 0, index = 1; i < 5; i++, index ++) {
            int count = 0;
            for (int j = 0; j < 6; j++) {
                if (MainQueue[i][j] == null) {
                    count++;
                }
            }
            if (count > 0){System.out.println("Queue "+ index +" is empty " + "("+count + " empty slots are available)");}

        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    static void addCustomer()  {
        boolean addLoop = true;

        while (addLoop){
            boolean innerAddLoop = true;
            System.out.print("Enter customer first name- ");
            String fName = sc.next();
            System.out.print("Enter customer second name- ");
            String sName = sc.next();
            System.out.print("Enter number of fuel litres required by the customer- ");
            int fVol =  sc.nextInt();
            System.out.print("Enter vehicle number- ");
            String  vNo = sc.next();
            System.out.println();

            if (checkIfFull()) {
                System.out.println("!!!!!!!! Currently All the fuel Queues are full !!!!!!!!");
                System.out.println("Please wait! Customer is being added to the waiting list" + "\n");

                FuelQueue waitingQueue = new FuelQueue();

                waitingQueue.setFName(fName);
                waitingQueue.setLName(sName);
                waitingQueue.setLicNo(vNo);
                waitingQueue.setFuelVolume(fVol);
                WaitingQueue.enQueue(waitingQueue);

                System.out.println("Customer added to the waiting queue successfully");

            } else{
                int count[] = {0, 0, 0, 0, 0};

                for (int i = 0; i < 5; i++) {
                    int blankCount = 0;
                    for (int j = 0; j < 6; j++) {
                        if (MainQueue[i][j] == null) {
                            blankCount++;
                        }
                        count[i] = blankCount;
                    }
                }
//                    for (int j = 0; j < 6; j++) {
//                        if (blankCount > highest) {
//                            highest = blankCount;
//                            index = i;
//                        }
//                    }
                int highest = 0, index = -1;
                for (int i = 0; i < 5; i++) {
                    if(count[i] > highest){
                        highest = count[i];
                        index = i;
                    }

                }

                MainQueue[index][(6-highest)] = new FuelQueue();

                MainQueue[index][(6-highest)].setFName(fName);
                MainQueue[index][(6-highest)].setLName(sName);
                MainQueue[index][(6-highest)].setLicNo(vNo);
                MainQueue[index][(6-highest)].setFuelVolume(fVol);

                System.out.println("Customer added to the " +(index+1)+ " queue successfully");
            }

            while (innerAddLoop) {
                System.out.print("Do you want to add another customer \nIf yes enter Y \nIf not enter N \n");
                System.out.print("Enter your choice - ");
                String choice = sc.next();

                System.out.println();
                if (choice.equalsIgnoreCase("Y")) {
                    innerAddLoop = false;
                } else if (choice.equalsIgnoreCase("N")) {
                    addLoop = false;
                    innerAddLoop = false;
                } else {
                    System.out.println("Invalid Input. Please enter a valid input");
                    innerAddLoop = true;
                }
            }

        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    static void removeCustomer(){

        try {
            boolean removeLoop = true;

            while(removeLoop){
                boolean innerAddLoop = true;
                System.out.print("Enter the queue number you want to remove a customer from(1-5)- ");
                int queueNum = sc.nextInt();
                System.out.print("Enter the customer index number(1-6)- ");
                int indexNum = sc.nextInt();
                FuelQueue [][] duplicateQueue =  new FuelQueue[5][6];
                for (int j = 0,k = 0; j < 6; j++) {
                    if ( j != indexNum-1){
                        duplicateQueue[queueNum-1][k] = MainQueue[queueNum-1][j];
                        k++;
                    }

                }
                MainQueue[queueNum-1] = duplicateQueue[queueNum-1];

                for (int i = 0; i < 6; i++) {
                    if (MainQueue[queueNum-1][i] == null){
                        MainQueue[queueNum-1][i] = WaitingQueue.deQueue();
                    }

                }
                System.out.println("Customer removed from the queue successfully");
                while (innerAddLoop) {
                    System.out.println("Do you want to remove another customer \nIf yes enter Y \nIf not enter N ");
                    System.out.print("Enter your choice - ");
                    String choice = sc.next();
                    if (choice.equalsIgnoreCase("Y")) {
                        innerAddLoop = false;
                    } else if (choice.equalsIgnoreCase("N")) {
                        removeLoop = false;
                        innerAddLoop = false;
                    } else {
                        System.out.println("Invalid Input. Please enter a valid input");
                        innerAddLoop = true;
                    }
                }
            }
        } catch (Exception e){
            System.out.println("Invalid Input Please Try again ");
        }



    }
    //----------------------------------------------------------------------------------------------------------------------
    static boolean checkIfFull() {
        boolean isFull = false;
        //int count = 0;
        int count[] = {0,0,0,0,0};
        for (int i = 0;i < 5; i++) {
            int pCount = 0;
            for (int j = 0; j < 6; j++) {
                if (MainQueue[i][j] != null) {pCount++;}
            }
            count[i] = pCount;
        }
        int finaCount = 0;
        for (int i = 0; i < 5; i++) {
            if (count[i] == 6){finaCount++;}
        }
        if(finaCount == 5){isFull = true;}

        return isFull;
    }
    //---------------------------------------------------------------------------------------------------------------------
    static void serveCustomer(){
        boolean serveLoop = true;
        while (serveLoop){
            int temp = 0;
            boolean innerSerLoop = true;
            System.out.print("Enter the queue number you want to serve a customer from(1-5)- ");
            int queueNum = sc.nextInt();

            FuelQueue [][] duplicateQueue =  new FuelQueue[5][6];
            int volume  = MainQueue[queueNum-1][0].getFuelVolume();
            fuelVolume = fuelVolume - volume;

            fuelWarning();
            revenueArray[queueNum-1] = temp;
            revenueArray[queueNum-1] = temp + (volume * 430);

            for (int j = 0,k = 0; j < 6; j++) {
                if ( j != 0){
                    duplicateQueue[queueNum-1][k] = MainQueue[queueNum-1][j];
                    k++;
                }

            }
            MainQueue[queueNum-1] = duplicateQueue[queueNum-1];

            for (int i = 0; i < 6; i++) {
                if (MainQueue[queueNum-1][i] == null){
                    MainQueue[queueNum-1][i] = WaitingQueue.deQueue();
                }

            }
            System.out.println("Served the customer successfully");
            while (innerSerLoop) {
                System.out.println("Do you want to serve another customer \nIf yes enter Y \nIf not enter N ");
                System.out.print("Enter your choice - ");
                String choice = sc.next();
                System.out.println();

                if (choice.equalsIgnoreCase("Y")) {
                    innerSerLoop = false;
                } else if (choice.equalsIgnoreCase("N")) {
                    serveLoop = false;
                    innerSerLoop = false;
                } else {
                    System.out.println("Invalid Input. Please enter a valid input");
                    System.out.println();
                    innerSerLoop = true;
                }
            }

        }
    }
    //---------------------------------------------------------------------------------------------------------------------
    static void displayRevenue(){
        int count = 1;
        for (int i :revenueArray){
            System.out.print("Total income of Queue" + count +" "+ i);
            count++;
            System.out.println();
        }
    }
    //---------------------------------------------------------------------------------------------------------------------
    static void sortQueue() {
        String tempQueue[][] = new String[5][6];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                tempQueue[i][j] = MainQueue[i][j].getFName();
            }
        }
        String tempVar;
        for (int i = 0; i < tempQueue.length; i++) {
            for (int j = 0,k = 1; j < tempQueue[i].length; j++,k++) {
                for (int l = 0; l < 5; l++) {
                    if(tempQueue[i][l].compareTo(tempQueue[i][l+1])<0){
                        tempVar = tempQueue[i][l+1];
                        tempQueue[i][l+1] = tempQueue[i][l];
                        tempQueue[i][l] = tempVar;
                    }
                }

            }

        }

        for (int i = 0,index = 1; i < 5; i++, index ++) {
            System.out.println("Queue" + index);
            for (int j = 0; j < 6; j++) {
                if(tempQueue[i][j] == null){
                    System.out.print("Empty  ");
                }else {System.out.print(tempQueue[i][j]+ " ");}
            }
            System.out.println();
            System.out.println();
        }

    }
    //---------------------------------------------------------------------------------------------------------------------
    static void viewFuelAmount() throws InterruptedException {
        System.out.println("                                   Checking the remaining fuel stock");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(fuelVolume + "L remaining");
    }
    //---------------------------------------------------------------------------------------------------------------------
    static void addFuel() {
        System.out.print("Enter the amount of fuel you want to restock ");
        int newAmount = sc.nextInt();
        String output = "";
        int checkStock = fuelVolume + newAmount;
        if (checkStock > 6600) {
            output = ("                  !!!!!!!!!!!!!!!!!!!!!!ALERT!!!!!!!!!!!!!!!!!!!!\n" +
                    "                    Cannot restock fuel Maximum fuel limit exceeded \n" +
                    "                      Maximum amount you can refuel is " + (6600 - fuelVolume)+"L");
        } else {
            fuelVolume = fuelVolume + newAmount;
            output = ("Fuel restock successful. New stock = " + fuelVolume);
        }
        System.out.print(output);
        System.out.println();
    }
    //---------------------------------------------------------------------------------------------------------------------
    static void fuelWarning() {
        if (fuelVolume <= 500) {
            String msg = """
                                                    !!! Warning !!!
                                            Fuel stock has reached 500Liters
                    """;
            System.out.println(msg);
        }
    }
    //---------------------------------------------------------------------------------------------------------------------
    static void fileWrite() throws IOException {
        File file = new File("ProgramData.txt");
        file.createNewFile();

        FileWriter fw = new FileWriter(file);
        fw.write(String.valueOf(fuelVolume) +"\n");
        for (int i = 0; i < 5; i++) {
            fw.write("Queue Number- "+(i+1)+"\n");
            for (int j = 0; j < 6; j++) {
                fw.write(MainQueue[i][j].getFName() + " " + MainQueue[i][j].getLName() + " " + MainQueue[i][j].getFuelVolume() + " " + MainQueue[i][j].getLicNo() + " ");
                fw.write("\n");
            }

        }
        fw.close();
        System.out.println("Data Stored to the file successfully");
    }
    //---------------------------------------------------------------------------------------------------------------------
    static void loadFromFile() throws IOException {
        System.out.println("                     Retrieving Stored Data From The File Please Wait ");
        File file = new File("ProgramData.txt");
        FileReader fr = new FileReader(file);
        int i;
        while ((i=fr.read())!=-1){
            System.out.print((char)i);
        }
        fr.close();
    }
    //---------------------------------------------------------------------------------------------------------------------

}

