package com.example.fx;

public class WaitingQueue  {
    static FuelQueue[] waitingQueue = new FuelQueue[10];

    static int front = -1, rear = -1;


    // Check if the queue is full
    static boolean isFull() {
        if (front == 0 && rear == 9) {
            return true;
        }
        if (front == rear + 1) {
            return true;
        }
        return false;
    }

    // Check if the queue is empty
    static boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

    // Adding an element
    static void enQueue(FuelQueue element) {
        if (isFull()) {
            System.out.println("Waiting Queue is full");
        } else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % 10;
            waitingQueue[rear] = element;

        }
        System.out.println("Customer added to the waiting queue successfully");
    }

    // Removing an element
    static FuelQueue deQueue() {
        FuelQueue element;
        if (isEmpty()) {

            return (null);
        } else {
            element = waitingQueue[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } /* Q has only one element, so we reset the queue after deleting it. */ else {
                front = (front + 1) % 10;
            }
            return (element);
        }
    }

}
