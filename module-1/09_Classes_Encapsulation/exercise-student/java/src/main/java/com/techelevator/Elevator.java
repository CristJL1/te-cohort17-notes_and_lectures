package com.techelevator;

public class Elevator {

    private int currentFloor;

    private int numberOfFloors;

    private boolean doorOpen;


    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    public Elevator () {

        numberOfFloors = 10;
        currentFloor = 1;
        doorOpen = true;

    }



    public Elevator (int numberOfLevels) {

        numberOfFloors = numberOfLevels;
        currentFloor = 1;
        doorOpen = false;

    }

    public void openDoor() {

        doorOpen = true;

    }

    public void closeDoor() {

        doorOpen = false;
    }

    public void goUp (int desiredFloor) {

        if (!doorOpen && desiredFloor <= numberOfFloors && desiredFloor > currentFloor) {

            while (currentFloor < desiredFloor) {
                currentFloor = currentFloor +1;
            }
            }

        }


    public void goDown (int desiredFloor) {

        if (!doorOpen && desiredFloor >= 1 && desiredFloor < currentFloor) {
            while (currentFloor > desiredFloor) {
                currentFloor = currentFloor -1;
            }
            }
        }

    }







