package com.example.fx;

import java.util.Scanner;

public class Main extends FuelQueue {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("                                       Welcome to Fuel Queue Management System");
        boolean mainLoop = true;
        while (mainLoop){
            try {
                System.out.println("""     
                                         |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Fuel Center Management System~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
                                         |---------------------------------------------------MAIN MENU-----------------------------------------------------------------|
                                         |                                                                                                                             |
                                         |                          100 or VFQ:         View all Fuel Queues.                                                          |
                                         |                          101 or VEQ:         View all Empty Queues.                                                         |
                                         |                          102 or ACQ:         Add customer to a Queue.                                                       |
                                         |                          103 or RCQ:         Remove a customer from a Queue.                                                |
                                         |                          104 or PCQ:         Remove a served customer.                                                      |
                                         |                          105 or VCS:         View Customers Sorted in alphabetical order                                    |
                                         |                          106 or SPD:         Store Program Data into file.                                                  |
                                         |                          107 or LPD:         Load Program Data from file.                                                   |
                                         |                          108 or STK:         View Remaining Fuel Stock.                                                     |
                                         |                          109 or AFS:         Add Fuel Stock.                                                                | 
                                         |                          110 or IFQ          Print the income of each Fuel queue                                            |
                                         |                          111 or VUI          View user interface                                                            |
                                         |                          999 or EXT:         Exit the Program.                                                              |
                                         |-----------------------------------------------------------------------------------------------------------------------------|""");
                System.out.println("Choose the operation that you want to use");
                System.out.print("Enter your choice- ");
                String option = sc.next().toUpperCase();

                switch (option){
                    case "100","VFQ":
                        viewAllQueues();
                        break;
                    case "101","VEQ":
                        viewEmptyQueue();
                        break;
                    case "102","ACQ":
                        addCustomer();
                        break;
                    case "103","RCQ":
                        removeCustomer();
                        break;
                    case "104","PCQ":
                        serveCustomer();
                        break;
                    case "105","VCS":
                        sortQueue();
                        break;
                    case "106","SPD":
                        fileWrite();
                        break;
                    case "107","LPD":
                        loadFromFile();
                        break;
                    case "108","STK":
                        viewFuelAmount();
                        break;
                    case "109","AFS":
                        addFuel();
                        break;
                    case "110","IFQ":
                        displayRevenue();
                        break;
                    case "111","VUI":
                        launch();
                        break;
                    case "999","EXT":
                        System.out.println("Thank you for using Fuel Manager");
                        mainLoop = false;
                        break;
                    default:
                        System.out.println("Invalid Input\n" + "Please Try again");
                        break;
                }


            } catch (Exception e){
                //e.printStackTrace();
                System.out.println("Error Please try again");
            }

        }

    }
}
